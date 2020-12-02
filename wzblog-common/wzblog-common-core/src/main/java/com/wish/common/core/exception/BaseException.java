package com.wish.common.core.exception;

import lombok.Getter;

/**
 * @program: wz-blog
 * @description: 基础异常
 * @author: Ylover
 * @created: 2020/12/02 17:15
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    @Getter
    private String module;

    /**
     * 错误码
     */
    @Getter
    private String code;

    /**
     * 错误码对应的参数
     */
    @Getter
    private Object[] args;

    /**
     * 错误消息
     */
    @Getter
    private String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, String code, Object[] args)
    {
        this(module, code, args, null);
    }

    public BaseException(String module, String defaultMessage)
    {
        this(module, null, null, defaultMessage);
    }

    public BaseException(String code, Object[] args)
    {
        this(null, code, args, null);
    }

    public BaseException(String defaultMessage)
    {
        this(null, null, null, defaultMessage);
    }
}
