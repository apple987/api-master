package com.king.common.util;

import org.springframework.cache.annotation.CachingConfigurerSupport;

import java.lang.reflect.Method;  

import org.springframework.cache.CacheManager;  
import org.springframework.cache.annotation.EnableCaching;  
import org.springframework.cache.interceptor.KeyGenerator;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.data.redis.cache.RedisCacheManager;  
import org.springframework.data.redis.connection.RedisConnectionFactory;  
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;  
import org.springframework.data.redis.core.RedisTemplate;  
  
/** 
 * @author傅为地
 * 以Spring与配置文件来管理的redis缓存配置类 
 */  
@Configuration  
@EnableCaching  
public class RedisCacheConfig extends CachingConfigurerSupport{
	    private volatile JedisConnectionFactory connectionFactory;  
	    private volatile RedisTemplate<String, String> redisTemplate;  
	    private volatile RedisCacheManager cacheManager;  
	      
	    public RedisCacheConfig() {  
	        super();  
	    }  
	    
	    public RedisCacheConfig(JedisConnectionFactory connectionFactory,
				RedisTemplate<String, String> redisTemplate,
				RedisCacheManager cacheManager) {
			super();
			this.connectionFactory = connectionFactory;
			this.redisTemplate = redisTemplate;
			this.cacheManager = cacheManager;
		}


		public JedisConnectionFactory redisConnectionFactory() {  
	        return connectionFactory;  
	    }  
	  
	    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {  
	        return redisTemplate;  
	    }  
	  
	    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {  
	        return cacheManager;  
	    }  
	      
	    @Bean  
	    public KeyGenerator customKeyGenerator() {  
	        return new KeyGenerator() {  
	            @Override  
	            public Object generate(Object o, Method method, Object... objects) {  
	                StringBuilder sb = new StringBuilder();  
	                sb.append(o.getClass().getName());  
	                sb.append(method.getName());  
	                for (Object obj : objects) {  
	                    sb.append(obj.toString());  
	                }  
	                return sb.toString();  
	            }  
	        };  
	    }  
}
