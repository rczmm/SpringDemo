package com.rczmm.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * RedisConfig
 *
 * @author rczmm
 * @date 2024/05/20
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        /*
         *  使用 String 序列化器序列化和反序列化 redis 的 key 值
         *
         */
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        /*
         *  使用 Jackson 序列化器序列化和反序列化 redis 的 value 值
         */
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
//        template.setValueSerializer(serializer);
//        template.setValueSerializer(serializer);

        template.afterPropertiesSet();

        return template;

    }

}
