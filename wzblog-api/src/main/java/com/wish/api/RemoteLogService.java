package com.wish.api;

import com.wish.api.factory.RemoteLogFallbackFactory;
import com.wish.api.domain.SysLog;
import com.wish.common.core.domain.W;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "remoteLogService", value = "wzblog-admin", fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogService {
    /**
     * @description 保存操作日志 
     * @Param [sysLog]
     * @return com.wish.common.core.domain.W<java.lang.Boolean>
     * @author Ylover
     * @date 2020/11/29 23:26
     **/
    @PostMapping("/log")
    W<Boolean> saveLog(@RequestBody SysLog sysLog);
    
    /**
     * @description 保存访问记录 
     * @Param [username, status, message]
     * @return com.wish.common.core.domain.W<java.lang.Boolean>
     * @author Ylover
     * @date 2020/11/29 23:26
     **/
    @PostMapping("/records")
    W<Boolean> saveRecords(@RequestParam("username") String username, @RequestParam("status") String status, 
                          @RequestParam("message") String message);
}
