package com.jwt.demo.exec.common.response;

import com.jwt.demo.exec.common.enumeration.BusinessErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 封装返回实体
 * @author Modi Cheung
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 是否成功
     */
    private Boolean succ;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String msg;

    /**
     * 成功数据
     */
    private T data;

    /**
     * 服务器当前时间戳
     */
    private Long ts = System.currentTimeMillis();

    public Result() {
    }

    public Result(Boolean succ, String code, String msg, T data, Long ts) {
        this.succ = succ;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.ts = ts;
    }

    public static Result ofSuccess() {
        Result result = new Result();
        result.succ = true;
        return result;
    }

    public static <T> Result ofSuccess(T data) {
        Result result = new Result();
        result.succ = true;
        result.data = data;
        return result;
    }

    public static Result ofFail(String code, String msg) {
        Result result = new Result();
        result.succ = false;
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static <T> Result ofFail(String code, String msg, T data) {
        Result result = new Result();
        result.succ = false;
        result.code = code;
        result.msg = msg;
        result.data = data;
        return result;
    }

    public static Result ofFail(BusinessErrorCode errorCodeEnum) {
        Result result = new Result();
        result.succ = false;
        result.code = errorCodeEnum.getErrorcode();
        result.msg = errorCodeEnum.getErrormsg();
        return result;
    }
}
