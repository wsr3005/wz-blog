package com.wish.common.log.aspect;

import com.alibaba.fastjson.JSON;
import com.wish.api.RemoteLogService;
import com.wish.api.pojo.SysLog;
import com.wish.common.core.constant.CacheConstants;
import com.wish.common.core.utils.ServletUtils;
import com.wish.common.core.utils.ip.IpUtils;
import com.wish.common.log.annotation.Log;
import com.wish.common.log.enums.BusinessStatus;
import com.wish.common.log.service.AsyncLogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @program: wzblog
 * @description: 日志切面
 * @author: Ylover
 * @created: 2020/11/25 19:11
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    
    @Autowired
    private AsyncLogService asyncLogService;
    
    @Pointcut("@annotation(com.wish.common.log.annotation.Log)")
    public void logPointCut(){
        
    }
    
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturnting(JoinPoint joinPoint, Object jsonResult){
        handleLog(joinPoint, null, jsonResult);
    }
    
    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e){
        handleLog(joinPoint, e, null);
    }
    
    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult){
        try {
            Log controllerLog = getAnnotationLog(joinPoint);
            if (controllerLog == null) {
                return;
            }

            SysLog sysLog = new SysLog();
            sysLog.setStatus(BusinessStatus.SUCCESS.ordinal());
            String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
            sysLog.setOperIp(ip);
            sysLog.setJsonResult(JSON.toJSONString(jsonResult));
            sysLog.setOperUrl(ServletUtils.getRequest().getRequestURI());
            String username = ServletUtils.getRequest().getHeader(CacheConstants.DETAILS_USERNAME);
            if (StringUtils.isNotBlank(username)){
                sysLog.setOperName(username);
            }
            
            if (e != null){
                sysLog.setStatus(BusinessStatus.FAIL.ordinal());
                sysLog.setErrorMsg(e.getMessage().substring(0, 2000));
            }
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            sysLog.setMethod(className + "." + methodName + "()");
            sysLog.setRequestMethod(ServletUtils.getRequest().getMethod());
            getControllerMethodDescription(joinPoint, controllerLog, sysLog);

            asyncLogService.saveLog(sysLog);    
        }catch (Exception exp){
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }
    
    public boolean isFilterObject(final Object o){
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse;
    }
    
    private String argsArrayToString(Object[] paramsArray){
        String params = "";
        if (paramsArray != null && paramsArray.length > 0){
            for (int i = 0; i < paramsArray.length; i++) {
                if (!isFilterObject(paramsArray[i])){
                    try {
                        Object jsonObj = JSON.toJSON(paramsArray[i]);
                        params += jsonObj.toString() + " ";
                    }catch (Exception e){}
                }
            }
        }
        return params.trim();
    }
       
    
    public void setRequestValue(JoinPoint joinpoint, SysLog sysLog){
        String requestMethod = sysLog.getRequestMethod();
        if (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod)){
            String params = argsArrayToString(joinpoint.getArgs());
            sysLog.setOperParam(params);
        }
    }
    
    private Log getAnnotationLog(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        
        if (method != null)
            return method.getAnnotation(Log.class);
        return null;
    }
    
    public void getControllerMethodDescription(JoinPoint joinpoint, Log log, SysLog sysLog){
        sysLog.setBusinessType(log.businessType().ordinal());
        sysLog.setTitle(log.title());
        sysLog.setOperatorType(log.operatorType().ordinal());
        if (log.isSaveRequestData())
            setRequestValue(joinpoint, sysLog);
    }
}
