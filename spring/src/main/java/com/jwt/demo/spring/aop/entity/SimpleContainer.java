package com.jwt.demo.spring.aop.entity;

import com.jwt.demo.spring.di.SimpleInject;

import java.lang.reflect.Field;

public class SimpleContainer {

    public static <T> T getInstance(Class<T> cls) {
        try {
            T obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(SimpleInject.class)) { // 只对标识[自动注入]的属性设置可访问，创建实例并set
                    if (!field.isAccessible()) { // 如果是private的
                        field.setAccessible(true);
                    }
                    Class<?> fieldCls = field.getType();
                    field.set(obj, getInstance(fieldCls));
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ServiceA serviceA = SimpleContainer.getInstance(ServiceA.class);
        serviceA.callB();
    }
}
