package com.jwt.demo.exec.common.exception;

import com.jwt.demo.exec.common.enumeration.BusinessErrorCode;
import lombok.Data;

/**
 * 异常基类
 */
@Data
public class BaseException extends RuntimeException {

    private String code;


    public BaseException(BusinessErrorCode businessErrorCode) {
        super(businessErrorCode.getErrormsg());
        this.code = businessErrorCode.getErrorcode();
    }

    public BaseException(String code, String msg) {
        super(msg);
        this.code = code;
    }

}
