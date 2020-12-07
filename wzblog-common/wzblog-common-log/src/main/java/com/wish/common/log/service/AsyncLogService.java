package com.wish.common.log.service;

import com.wish.api.RemoteLogService;
import com.wish.api.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: wzblog
 * @description: 异步调用日志服务
 * @author: Ylover
 * @created: 2020/11/25 19:13
 */
@Service
public class AsyncLogService {
    
    @Autowired
    private RemoteLogService remoteLogService;
    
    @Async
    public void saveLog(SysLog sysLog){
        remoteLogService.saveLog(sysLog);
    }
}
