package com.wish.api.domain;

import com.wish.common.core.web.domain.BaseEntity;
import lombok.*;

/**
 * @program: wz-blog
 * @description: 角色表
 * @author: Ylover
 * @created: 2020/12/02 18:00
 */

@Getter
@Setter
@ToString
public class UserRole extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    private Long roleId;

    /** 角色名称 */
    private String roleName;

    public UserRole() {
    }

    public UserRole(Long roleId) {
        this.roleId = roleId;
    }
}
