package com.jwt.demo.spring.aop.simpleFramework;

import com.jwt.demo.spring.aop.entity.ServiceA;
import com.jwt.demo.spring.aop.entity.ServiceB;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
@Aspect({ServiceA.class, ServiceB.class})
public class ServiceLogAspect {

    public void before(Object obj, Method method, Object[] args) {
        log.info("entering " + Object.class.getSimpleName() + "::" + method.getName());
    }

    public void after(Object obj, Method method, Object[] args, Object result) {
        log.info("leaving " + Object.class.getSimpleName() + "::" + method.getName());
    }

    public static void main(String[] args) {
//        cglib
    }
}
