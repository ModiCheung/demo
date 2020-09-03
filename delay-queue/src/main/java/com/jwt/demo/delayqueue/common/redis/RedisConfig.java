package com.jwt.demo.delayqueue.common.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * redis配置
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

//    @Bean
//    public LettuceConnectionFactory lettuceConnectionFactory(RedisConfiguration redisConfiguration) {
//        return new LettuceConnectionFactory(redisConfiguration);
//    }

//    @Bean
//    public RedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory()
//    }

//    @Bean
//    public JedisPoolConfig jedisPoolConfig(@Value("${jedis.maxTotal}") int maxActive,
//                                           @Value("${jedis.maxIdle}") int maxIdle,
//                                           @Value("${jedis.minIdle}") int minIdle,
//                                           @Value("${jedis.maxWaitMillis}") long maxWaitMillis,
//                                           @Value("${jedis.testOnBorrow}") boolean testOnBorrow) {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(maxActive);
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMinIdle(minIdle);
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
//
//        return jedisPoolConfig;
//    }

//    @Bean
//    public JedisPool jedisPool(@Value("${jedis.host}") String host,
//                               @Value("${jedis.password}") String password,
//                               @Value("${jedis.port}") int port,
//                               @Value("${jedis.timeout}") int timeout, JedisPoolConfig jedisPoolConfig) {
//
////        log.info("=====创建JedisPool连接池=====");
//        if(!StringUtils.isEmpty(password)) {
//            return new JedisPool(jedisPoolConfig, host, port, timeout, password);
//        }
//
//        return new JedisPool(jedisPoolConfig, host, port, timeout);
//    }

    /**
     * TODO 后续需要处理单机和集群两种模式的切换
     * @return
     */
//    @Bean
//    public RedisConfiguration redisConfiguration() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host, port);
//        redisStandaloneConfiguration.setPassword(password);
//        return redisStandaloneConfiguration;
//    }


}
