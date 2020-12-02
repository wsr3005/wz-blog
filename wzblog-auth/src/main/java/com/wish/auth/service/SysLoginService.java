package com.wish.auth.service;

import com.wish.api.RemoteLogService;
import com.wish.api.RemoteUserService;
import com.wish.api.domain.User;
import com.wish.api.model.LoginUser;
import com.wish.common.core.constant.Constants;
import com.wish.common.core.constant.UserConstants;
import com.wish.common.core.domain.W;
import com.wish.common.core.enums.UserStatus;
import com.wish.common.core.exception.BaseException;
import com.wish.common.security.utils.SecurityUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: wz-blog
 * @description: 登录校验方法
 * @author: Ylover
 * @created: 2020/12/02 17:34
 */
@Component
public class SysLoginService {
    @Autowired
    private RemoteLogService remoteLogService;
    
    @Autowired
    private RemoteUserService remoteUserService;
    
    public LoginUser login(String username, String password){
        if (StringUtils.isAnyBlank(username, password)){
            remoteLogService.saveRecords(username, Constants.LOGIN_FAIL, "用户名/密码必须填写");
        }
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH){
            remoteLogService.saveRecords(username, Constants.LOGIN_FAIL, "用户密码不在指定范围");
            throw new BaseException("用户密码不在指定范围");
        }
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH){
            remoteLogService.saveRecords(username, Constants.LOGIN_FAIL, "用户名不在指定范围");
            throw new BaseException("用户名不在指定范围");
        }
        W<LoginUser> userResult = remoteUserService.getUserInfo(username);
        
        if (W.FAIL == userResult.getCode()){
            throw new BaseException(userResult.getMsg());
        }
        if (userResult.getData() == null){
            remoteLogService.saveRecords(username, Constants.LOGIN_FAIL, "登录用户不存在");
            throw new BaseException("登录用户：" + username + " 不存在");
        }
        LoginUser loginUser = userResult.getData();
        User user = userResult.getData().getUser();
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag())){
            remoteLogService.saveRecords(username, Constants.LOGIN_FAIL, "对不起，您的账号已被删除");
            throw new BaseException("对不起，您的账号：" + username + " 已被删除");
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus())){
            remoteLogService.saveRecords(username, Constants.LOGIN_FAIL, "用户已停用，请联系管理员");
            throw new BaseException("对不起，您的账号：" + username + " 已停用");
        }
        if (!SecurityUtils.matchesPassword(password, user.getPassword())){
            remoteLogService.saveRecords(username, Constants.LOGIN_FAIL, "用户密码错误");
            throw new BaseException("用户不存在/密码错误");
        }
        remoteLogService.saveRecords(username, Constants.LOGIN_SUCCESS, "登录成功");
        return loginUser;
    }
    
    public void logout(String loginName){
        remoteLogService.saveRecords(loginName, Constants.LOGOUT, "退出成功");
    }
}
