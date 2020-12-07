package com.wish.api.domain;

import com.wish.common.core.web.domain.BaseEntity;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @program: wz-blog
 * @description: 用户对象
 * @author: Ylover
 * @created: 2020/12/02 17:53
 */

@Getter
@Setter
@ToString
public class User extends BaseEntity {
    /** 用户ID */
    private Long userId;

    /** 用户账号 */
    private String userName;

    /** 用户昵称 */
    private String nickName;
    
    /** 用户类型 */
    private String userType;

    /** 用户邮箱 */
    private String email;

    /** 用户性别 0=男,1=女,2=未知*/
    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 盐加密 */
    private String salt;

    /** 帐号状态（0正常 1停用） */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 最后登录IP */
    private String loginIp;

    /** 最后登录时间 */
    private Date loginDate;

    /** 角色对象 */
    private List<UserRole> roles;

    /** 角色组 */
    private Long[] roleIds;
    
    public User(Long userId){
        this.userId = userId;
    }

    public User() {
    }
}
