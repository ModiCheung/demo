package com.jwt.demo.exec.common.enumeration;

/**
 * @Description 错误码罗列
 */
public enum BusinessErrorCode {

    UNKNOWN_ERROR("0001", "未知异常"),

    INVALID_PARAM("0002", "非法参数");

    private String errorcode;

    private String errormsg;

    BusinessErrorCode(String errorcode, String errormsg) {
        this.errorcode = errorcode;
        this.errormsg = errormsg;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
}
