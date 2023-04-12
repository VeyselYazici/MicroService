package com.vky.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableCaching // Spring - java icin onbelleklemeyi aktif etmek icin kullanilir.
@EnableRedisRepositories    // Spring - Redis icin repositoryleri aktif etmek icin kullanilir.
public class RedisConfiguration {
    @Value("${spring.redis.host}")
    String host;
    @Bean
    public LettuceConnectionFactory redisConnectionFactory()
    {
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration(host,6379));
    }
}
