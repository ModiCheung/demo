package com.jwt.demo.delayqueue.controller;

import com.jwt.demo.delayqueue.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${redis-lua.delayQueueLua}")
    private String script;

    @RequestMapping("/test")
    public void test() {
        List<String> keys = new ArrayList<>();
        keys.add("delay-queue");
        long now = System.currentTimeMillis();
        String s = RedisUtil.eval(redisTemplate, script, keys, String.valueOf(now));
        System.out.println(s);
    }
}
