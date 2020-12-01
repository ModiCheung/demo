package com.jwt.demo.spring.aop.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理：可以实现对接口的动态代理
 */
public class GeneralDynamicProxyDemo {

    interface IServiceA {
        void sayHello();
    }

    static class IServiceAImpl implements IServiceA {
        @Override
        public void sayHello() {
            System.out.println("helloA!");
        }
    }

    interface IServiceB {
        void sayHello();
    }

    static class IServiceBImpl implements IServiceB {
        @Override
        public void sayHello() {
            System.out.println("helloB!");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler {

        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(realObj.getClass().getSimpleName() + "::" + method.getName() + " start...");
            method.invoke(realObj, args);
            System.out.println(realObj.getClass().getSimpleName() + "::" + method.getName() + " end...");
            return null;
        }
    }

    private static <T> T getProxy(Class<T> intf, T realObj) {
        return (T) Proxy.newProxyInstance(intf.getClassLoader(), new Class[]{intf}, new SimpleInvocationHandler(realObj));
    }

    public static void main(String[] args) {
        IServiceA iServiceA = new IServiceAImpl();
        IServiceA proxyService = getProxy(IServiceA.class, iServiceA);
        proxyService.sayHello();

        IServiceB iServiceB = new IServiceBImpl();
        IServiceB proxyServiceB = getProxy(IServiceB.class, iServiceB);
        proxyServiceB.sayHello();
    }



}
