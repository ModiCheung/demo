package com.jwt.demo.spring.aop.entity;

import com.jwt.demo.spring.di.SimpleInject;

import java.lang.reflect.Field;

public class ServiceA {

    @SimpleInject
    ServiceB b;

    public void callB() {
        b.action();
    }
}
