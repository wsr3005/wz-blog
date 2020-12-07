package com.wish.api.model;

import com.wish.api.domain.User;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * @program: wz-blog
 * @description: 用户信息
 * @author: Ylover
 * @created: 2020/12/02 17:48
 */
@Getter
@Setter
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 用户名id
     */
    private Long userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 权限列表
     */
    private Set<String> permissions;

    /**
     * 角色列表
     */
    private Set<String> roles;

    /**
     * 用户信息
     */
    private User user;
}
