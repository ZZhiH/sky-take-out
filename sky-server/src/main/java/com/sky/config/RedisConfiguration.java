package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * The RedisConfiguration.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/17 22:47
 */
@Configuration
@Slf4j
public class RedisConfiguration {

    @Bean
    public RedisTemplate redisTemplate(final RedisConnectionFactory redisConnectionFactory) {
        log.info("Create redis template");
        final RedisTemplate redisTemplate = new RedisTemplate();
        // set redis connection factory
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // set redis key serialization
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}
