package com.jwt.demo.delayqueue.common.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

public class RedisUtil {

    /**
     * 执行lua脚本：springboot先按evalsha执行，成功则返回结果，如果缓存没有该脚本，则进入异常部分，最终使用eval命令执行
     * @param redisTemplate
     * @param script
     * @param keys 键的集合
     * @param args 参数集合(不定项参数)
     * @return
     */
    public static Object eval(RedisTemplate redisTemplate, String script, List keys, Object... args) {
        DefaultRedisScript<String> defaultRedisScript = new DefaultRedisScript<String>();
        defaultRedisScript.setResultType(String.class);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        defaultRedisScript.setScriptText(script);
        Object execute = redisTemplate.execute(defaultRedisScript, stringRedisSerializer, stringRedisSerializer, keys, args);
        System.out.println(execute);
        return execute;
    }



}
