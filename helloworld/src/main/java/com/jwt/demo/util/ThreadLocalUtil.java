//package com.jwt.demo.util;
//
//import java.util.Map;
//
//public class ThreadLocalUtil {
//
//    private static final MyThreadLocal<Map<String, Object>> threadLocal = new MyThreadLocal<>();
//
//    public static Map<String, Object> getMap() {
//        return threadLocal.get();
//    }
//
//    public static Object get(String key) {
//        Map<String, Object> map = threadLocal.get();
//        return map.get(key);
//    }
//
//    public static void set(String key, Object value) {
//        Map<String, Object> map = threadLocal.get();
//        map.put(key, value);
//    }
//
//    public static void clear() {
//        threadLocal.remove();
//    }
//}
