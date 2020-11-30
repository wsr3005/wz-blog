package com.wish.common.core.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: wz-blog
 * @description:
 * @author: Ylover
 * @created: 2020/11/30 15:32
 */
public class ServletUtils {
    
    /**
     * @description 获取request 
     * @Param []
     * @return javax.servlet.http.HttpServletRequest
     * @author Ylover
     * @date 2020/11/30 17:18
     **/
    public static HttpServletRequest getRequest(){
        return getRequestAttributes().getRequest();
    }
    
    /**
     * @description 获取response 
     * @Param []
     * @return javax.servlet.http.HttpServletResponse
     * @author Ylover
     * @date 2020/11/30 17:18
     **/
    public static HttpServletResponse getResponse(){
        return getRequestAttributes().getResponse();
    }
    
    /**
     * @description 获取session 
     * @Param []
     * @return javax.servlet.http.HttpSession
     * @author Ylover
     * @date 2020/11/30 17:19
     **/
    public static HttpSession getSession(){
        return getRequest().getSession();
    }
    
    public static ServletRequestAttributes getRequestAttributes(){
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }
}
