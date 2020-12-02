package com.wish.api.factory;

import com.wish.api.RemoteLogService;
import com.wish.api.domain.SysLog;
import com.wish.common.core.domain.W;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @program: wz-blog
 * @description:
 * @author: Ylover
 * @created: 2020/11/27 20:32
 */
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService> {

    public static final Logger log = LoggerFactory.getLogger(RemoteLogFallbackFactory.class);
    
    @Override
    public RemoteLogService create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService() {
            @Override
            public W<Boolean> saveLog(SysLog sysLog) {
                return null;
            }
            
            @Override
            public W<Boolean> saveRecords(String username, String status, String message) {
                return null;
            }
        };
    }

    
}
