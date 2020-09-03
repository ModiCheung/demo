package com.jwt.demo.delayqueue.controller;

import com.jwt.demo.delayqueue.common.redis.RedisUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DefaultKafkaConsumerFactory kafkaConsumerFactory;

    @Value("${redis-lua.delayQueueLua}")
    private String script;

    @RequestMapping("/test")
    public void test() {
        List<String> keys = new ArrayList<>();
        keys.add("delay-queue");
        long now = System.currentTimeMillis();
        RedisUtil.eval(redisTemplate, script, keys, String.valueOf(now));
//        System.out.println(s);


    }

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<Integer, String> msg) {
        // 消费到数据后的处理逻辑
        System.out.println("kafka: "+msg);
    }
}
