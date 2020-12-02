package com.wish.auth.form;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: wz-blog
 * @description: 用户登录对象
 * @author: Ylover
 * @created: 2020/12/02 18:12
 */
@Getter
@Setter
public class LoginBody {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid = "";
}
