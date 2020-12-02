package com.wish.common.security.utils;

import com.wish.common.core.constant.CacheConstants;
import com.wish.common.core.utils.ServletUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: wz-blog
 * @description: 权限获取工具类
 * @author: Ylover
 * @created: 2020/12/02 19:42
 */
public class SecurityUtils {
    
    /**
     * @description 获取用户 
     * @Param []
     * @return java.lang.String
     * @author Ylover
     * @date 2020/12/2 19:44
     **/
    public static String getUserName(){
        return ServletUtils.getRequest().getHeader(CacheConstants.DETAILS_USERNAME);
    }
    
    /**
     * @description 获取用户id 
     * @Param []
     * @return java.lang.Long
     * @author Ylover
     * @date 2020/12/2 19:59
     **/
    public static Long getUserId(){
        return Long.parseLong(ServletUtils.getRequest().getHeader(CacheConstants.DETAILS_USER_ID));
    }
    /**
     * @description 是否是管理员 
     * @Param [userId]
     * @return boolean
     * @author Ylover
     * @date 2020/12/2 19:59
     **/
    public static boolean isAdmin(Long userId){
        return userId != null && 1L == userId;
    }
    
    /**
     * @description 密码加密 
     * @Param [password]
     * @return java.lang.String
     * @author Ylover
     * @date 2020/12/2 20:00
     **/
    public static String encryptPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
    /**
     * @description 密码是否相同 
     * @Param [rawPassword, encodedPassword]
     * @return boolean
     * @author Ylover
     * @date 2020/12/2 20:00
     **/
    public static boolean matchesPassword(String rawPassword, String encodedPassword){
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }
}
