package com.jwt.demo.spring.aop.simpleFramework;

import com.jwt.demo.spring.aop.entity.ServiceB;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
@Aspect({ServiceB.class})
public class ServiceExceptionAspect {

    public void before(Object obj, Method method, Object[] args) {
        log.info("entering " + Object.class.getSimpleName() + "::" + method.getName());
    }

    public void after(Object obj, Method method, Object[] args, Object result) {
        log.info("leaving " + Object.class.getSimpleName() + "::" + method.getName());
    }

    public void exception(Object obj, Method method, Object[] args, Throwable e) {
        log.info(Object.class.getSimpleName() + "::" + method.getName() + " throwing exception " + e);
    }


}
