package com.wish.api.factory;

import com.wish.api.RemoteUserService;
import com.wish.api.model.LoginUser;
import com.wish.common.core.domain.W;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: wz-blog
 * @description: 用户服务降级处理
 * @author: Ylover
 * @created: 2020/12/02 18:24
 */
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);


    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public W<LoginUser> getUserInfo(String username) {
                return W.fail("获取用户失败:" + throwable.getMessage());
            }
        };
    }
}
