package com.jwt.demo.redis.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLettuce {

    /**
     * get started
     */
    @Test
    public void test(){
        RedisClient redisClient = RedisClient.create("redis://paas123@172.23.0.217:30947/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> redisCommands = connection.sync();
        String set = redisCommands.set("aaa", "bbb");
        System.out.println(set);
    }

    @Test
    public void contructRedisURI() {
        RedisClient redisClient = RedisClient.create("redis://paas123@172.23.0.217:30947/0");
        RedisURI redisURI = RedisURI.builder().withHost("172.23.0.217").withPort(30947).withPassword("paas123".toCharArray()).withDatabase(0).build();

    }
}
