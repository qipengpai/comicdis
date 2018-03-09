package com.crxl.qpp.comicdis.redis;

import com.crxl.qpp.comicdis.configuration.MixCacheManager;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     *    生成key的策略
     *
     * @author pengpai
     * @date 2018/3/9 15:13
     * @param []
     * @return org.springframework.cache.interceptor.KeyGenerator
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    /**
     *    管理缓存
     *
     * @author pengpai
     * @date 2018/3/9 15:18
     * @param [redisTemplate]
     * @return org.springframework.cache.CacheManager
     */
    @Bean
    @Primary
    public CacheManager cacheManager(RedisCacheManager redisCacheManager,JCacheCacheManager jcacheCacheManager) {
        MixCacheManager cacheManager = new MixCacheManager();
        cacheManager.setRedisCacheManager(redisCacheManager);
        cacheManager.setMemCacheManager(jcacheCacheManager);
        return cacheManager;
    }

    /**
     *    RedisTemplate配置
     *
     * @author pengpai
     * @date 2018/3/9 15:16
     * @param [factory]
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.String,java.lang.String>
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
