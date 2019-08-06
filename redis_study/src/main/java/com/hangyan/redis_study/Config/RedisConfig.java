package com.hangyan.redis_study.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory)
    {
        RedisTemplate<String,String> redidTemplate = new RedisTemplate<String, String>();
        redidTemplate.setConnectionFactory(factory);
        return redidTemplate;

    }
}
