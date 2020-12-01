package com.wish.common.log.annotation;

import com.wish.common.log.enums.BusinessType;
import com.wish.common.log.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @program: wzblog
 * @description: 自定义操作日志注解
 * @author: Ylover
 * @created: 2020/11/25 19:11
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;
}
