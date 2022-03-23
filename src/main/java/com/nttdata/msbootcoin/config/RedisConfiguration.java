package com.nttdata.msbootcoin.config;


import com.nttdata.msbootcoin.model.Bootcoin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    ReactiveRedisOperations<String, Bootcoin> redisOperations(ReactiveRedisConnectionFactory factory) {
    	
    Jackson2JsonRedisSerializer<Bootcoin> serializer = new Jackson2JsonRedisSerializer<>(Bootcoin.class);

    RedisSerializationContext.RedisSerializationContextBuilder<String, Bootcoin> builder =
        RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

    RedisSerializationContext<String, Bootcoin> context = builder.value(serializer).build();

    return new ReactiveRedisTemplate<>(factory, context);
  }

}
