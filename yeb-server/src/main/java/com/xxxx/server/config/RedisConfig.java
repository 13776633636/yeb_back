package com.xxxx.server.config;

/**
 * Redis配置类
 *
 * @author zhoubin
 * @since 1.0.0
 */
/*
@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();

		// 解决jackson2无法反序列化LocalDateTime的问题
		om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		om.registerModule(new JavaTimeModule());

		//String类型 key序列器
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//String类型 value序列器
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		//Hash类型 key序列器
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		//Hash类型 value序列器
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}

}*/

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {
    /**
     * 定义 UserRedisTemplate ，指定序列化和反序列化的处理类
     *
     * @param factory redis连接工厂
     * @return 模板
     */
    @Bean("UserRedisTemplate")
    public RedisTemplate<String, Object> userRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer<Object> j2jrs = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 解决jackson2无法反序列化LocalDateTime的问题
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.registerModule(new JavaTimeModule());
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        j2jrs.setObjectMapper(om);
        // 序列化 value 时使用此序列化方法
        template.setValueSerializer(j2jrs);
        template.setHashValueSerializer(j2jrs);
        // 序列化 key 时
        StringRedisSerializer srs = new StringRedisSerializer();
        template.setKeySerializer(srs);
        template.setHashKeySerializer(srs);
        template.afterPropertiesSet();

		//String类型 key序列器
		template.setKeySerializer(new StringRedisSerializer());
		//String类型 value序列器
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		//Hash类型 key序列器
		template.setHashKeySerializer(new StringRedisSerializer());
		//Hash类型 value序列器
		template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setConnectionFactory(factory);

        return template;
    }
}
