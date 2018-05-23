package com.personalWebsite.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author xaitl
 * @date 2018-05-20 20:11
 */
public class RedisCache {


    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 插入(key存在会直接覆盖)
     *
     * @param key   key
     * @param value value
     */
    @SuppressWarnings("unchecked")
    public void setCache(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 插入(key存在会直接覆盖)
     *
     * @param key   key
     * @param value value
     * @param time  超时时间
     */
    @SuppressWarnings("unchecked")
    public void setCache(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }


    public Object getChche(String key) {
        return redisTemplate.opsForValue().get(key);
    }


}
