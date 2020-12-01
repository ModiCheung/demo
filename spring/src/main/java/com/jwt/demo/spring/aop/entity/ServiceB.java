package com.jwt.demo.spring.aop.entity;

public class ServiceB {

    private String value;

    public ServiceB() {
    }

    public ServiceB(String value) {
        this.value = value;
    }

    public void action() {
        System.out.println("i am B");
    }
}
