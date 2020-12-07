package com.wish.api;

import com.wish.api.factory.RemoteUserFallbackFactory;
import com.wish.api.model.LoginUser;
import com.wish.common.core.domain.W;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "remoteUserService", value = "wzblog-system", fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {
    @GetMapping(value = "/user/info/{username}")
    public W<LoginUser> getUserInfo(@PathVariable("username") String username);
}
