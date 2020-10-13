package com.jwt.demo.spring.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理：可以实现对类和接口的动态代理
 *
 * 实现机制：通过继承的方式来实现的，被动态创建的代理类继承了被代理类，并重写了所有public非final的方法，改为调用Callback中的相关方法
 */
public class SimpleCGLibDemo {

    static class RealService {
        void sayHello() {
            System.out.println("hello!");
        }
    }

    static class SimpleMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = methodProxy.invokeSuper(obj, args);
            System.out.println("leaving " + method.getName());
            return result;
        }

    }

    private static <T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleMethodInterceptor());
        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        RealService realService = new RealService();
        RealService proxy = getProxy(RealService.class);
        proxy.sayHello();
    }
}
