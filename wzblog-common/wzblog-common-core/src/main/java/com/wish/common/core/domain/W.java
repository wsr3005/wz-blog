package com.wish.common.core.domain;

import com.wish.common.core.constant.Constants;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: wz-blog
 * @description: 信息响应主体
 * @author: Ylover
 * @created: 2020/11/29 21:25
 */

@Data
public class W<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final int SUCCESS = Constants.SUCCESS;
    
    public static final int FAIL = Constants.FAIL;
    
    private int code;
    
    private String msg;
    
    private T data;
    
    public static <T> W<T> restResult(T data, int code, String msg){
        W<T> apiResult = new W<T>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    
    public static <T> W<T> ok(){
        return restResult(null, SUCCESS, null);
    }

    public static <T> W<T> ok(T data){
        return restResult(data, SUCCESS, null);
    }

    public static <T> W<T> ok(T data, String msg){
        return restResult(data, SUCCESS, msg);
    }

    public static <T> W<T> fail(){
        return restResult(null, FAIL, null);
    }

    public static <T> W<T> fail(T data){
        return restResult(data, FAIL, null);
    }

    public static <T> W<T> fail(String msg){
        return restResult(null, FAIL, msg);
    }

    public static <T> W<T> fail(T data, String msg){
        return restResult(data, FAIL, msg);
    }

    public static <T> W<T> fail(int code, String msg){
        return restResult(null, code, msg);
    }
    
}
