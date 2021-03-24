package com.jwt.demo.middleware.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

@Component
public class KafkaTask implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        HashMap<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, String.valueOf("11111"));
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "81.70.161.129:9092");
        KafkaConsumer consumer = new KafkaConsumer(configs);
        consumer.subscribe(Arrays.asList("aaa"));
        while (true) {
            ConsumerRecords records = consumer.poll(0);
            Iterator iterator = records.iterator();
            while (iterator.hasNext()) {
                ConsumerRecord record = (ConsumerRecord) iterator.next();
                System.out.println(record.value().toString());
            }
        }
    }
}
