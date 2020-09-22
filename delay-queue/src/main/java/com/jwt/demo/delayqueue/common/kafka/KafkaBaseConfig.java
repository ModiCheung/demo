package com.jwt.demo.delayqueue.common.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态创建Kafka消费者的基本配置(需外加serverList)
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "kafka")
public class KafkaBaseConfig {

    private boolean enableAutoCommit;

    private String autoCommitInterval;

    private String sessionTimeout;

    private String autoOffsetReset;

    private String maxPollRecords;

    // kafka消费者工厂类
//    @Bean
//    public DefaultKafkaConsumerFactory<String, String> kafkaConsumerFactory() {
//        return new DefaultKafkaConsumerFactory(consumerConfigs());
//    }

    /**
     * 构建Kafka配置，传入groupId -> 业务上可以使用
     * @param groupId
     * @return
     */
    public Map<String, Object> getConsumerConfigs(String groupId) {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        configs.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
        configs.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // TODO 有可能多个消费组订阅了相同的Topic，则需要为每个消费者设置一个消费者组ID，从而都可以收到消息
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        configs.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        return configs;
    }

    /**
     * 构建Kafka配置，传入groupId -> 业务上可以使用
     * @param groupId
     * @return
     */
    public Map<String, Object> getProducerConfigs(String groupId) {
        Map<String, Object> configs = new HashMap<>();
//        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
//        configs.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
//        configs.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "39.101.137.22:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // TODO 有可能多个消费组订阅了相同的Topic，则需要为每个消费者设置一个消费者组ID，从而都可以收到消息
//        configs.put(ProducerConfig.GROUP_ID_CONFIG, groupId);
//        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
//        configs.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        return configs;
    }

}
