package com.jwt.demo.spring.aop.simpleFramework;

import com.jwt.demo.spring.aop.entity.ServiceA;
import com.jwt.demo.spring.aop.entity.ServiceB;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ClassUtils.getMethod;

public class CGLibContainer {

    /**
     * 每个类的每个切点的方法列表
     */
    static Map<Class<?>, Map<InterceptPoint, List<Method>>> interceptMethodsMap;

    /**
     * 切面类的列表：本身应该扫描所有类来获取，此处简化
     */
    static Class<?>[] aspects = new Class<?>[]{ServiceA.class, ServiceB.class};

    static {
        init();
    }

    /**
     * 分析带@Aspect的类，初始化interceptMethodMap
     */
    public static void init() {
        // 遍历所有类，获取带有@Aspect注解的类
        for (Class<?> cls : aspects) {
            Aspect aspect = cls.getAnnotation(Aspect.class);
            if (aspect != null) {
                // 获取切面方法
                Method before = getMethod(cls, "before", new Class<?>[]{
                        Object.class, Method.class, Object[].class
                });
                Method after = getMethod(cls, "after", new Class<?>[]{
                        Object.class, Method.class, Object[].class, Object.class
                });
                Method exception = getMethod(cls, "before", new Class<?>[]{
                        Object.class, Method.class, Object[].class, Throwable.class
                });
                Class[] interceptArr = aspect.value();
                for (Class interceptted : interceptArr) {
                    addInterceptMethod(interceptted, InterceptPoint.BEFORE, before);
                    addInterceptMethod(interceptted, InterceptPoint.AFTER, after);
                    addInterceptMethod(interceptted, InterceptPoint.EXCEPTION, exception);
                }
            }
        }
    }

    public static void addInterceptMethod(Class<?> cls, InterceptPoint interceptPoint, Method interceptMethod) {

    }


    public static <T> T getInstance(Class<T> cls) {

        return null;
    }

    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        System.out.println(stringClass.getSimpleName());
        System.out.println(stringClass.getName());
        System.out.println(stringClass.getCanonicalName());
        System.out.println(stringClass.getPackage());
        System.out.println();
    }
}
