package com.jwt.demo.middleware.redis.lettuce.com.jwt.demo.middleware.redis.publish;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPublish {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testPublish() {
        redisTemplate.convertAndSend("test", "aaa");
    }
}
