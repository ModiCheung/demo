package com.jwt.demo.spring.aop.simpleFramework;

/**
 * 定义切面的拦截点
 */
public enum InterceptPoint {

    /** 方法前 **/
    BEFORE,
    /** 方法后 **/
    AFTER,
    /** 异常时 **/
    EXCEPTION;
}
