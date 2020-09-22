package com.jwt.demo.delayqueue.common.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class KafkaConfig {

    @Autowired
    private KafkaBaseConfig kafkaBaseConfig;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Bean
    public KafkaProducer kafkaProducer() {
        Map<String, Object> consumerConfigs = kafkaBaseConfig.getProducerConfigs("1");
        KafkaProducer kafkaProducer = new KafkaProducer<String, String>(consumerConfigs);
        return kafkaProducer;
    }


    @Scheduled(fixedDelay = 10000)
    public void run() throws ExecutionException, InterruptedException {
        ProducerRecord producerRecord = new ProducerRecord<String,String>("test", "message");
        Future send = kafkaProducer.send(producerRecord);
        send.get();
    }
}
