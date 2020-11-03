package com.qiding.jiaguo.controller;

import com.qiding.jiaguo.controller.cache.Cache;
import com.qiding.jiaguo.util.GsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Log4j2
@RestController
public class RedisCacheController implements Cache {

    @Autowired
    StringRedisTemplate redisTemplate;


    @PostMapping("cacheKey")
    @Override
    public <T> void cacheKey(@RequestParam(value = "key") String key, @RequestBody T value) {
        String cacheValue = GsonUtil.toGson(value);
        redisTemplate.opsForValue().set(key,cacheValue);
    }

    @PostMapping("cacheKeyWithEx")
    @Override
    public <T> void cacheKeyWithEx(@RequestParam(value = "key") String key, @RequestBody T value, @RequestParam(value = "cacheTime") Long cacheTime) {
        String cacheValue = GsonUtil.toGson(value);
        redisTemplate.opsForValue().set(key,cacheValue, cacheTime, TimeUnit.MILLISECONDS);
    }

    @PostMapping("cacheKeyWithAt")
    @Override
    public <T> void cacheKeyWithAt(@RequestParam(value = "key") String key, @RequestBody T value, @RequestParam(value = "expireAt") Long expireAt) {
        String cacheValue = GsonUtil.toGson(value);
        Long cacheTime = expireAt - Instant.now().toEpochMilli();
        redisTemplate.opsForValue().set(key,cacheValue, cacheTime,TimeUnit.MILLISECONDS);
    }


    @GetMapping("getValue")
    @Override
    public <T> T getValue(@RequestParam(value = "key") String key, @RequestParam(value = "className") String className) {
        String cacheData = redisTemplate.opsForValue().get(key);
        try {
            return (T) GsonUtil.parseJson(cacheData, Class.forName(className));
        } catch (ClassNotFoundException e) {
            log.error("消息转化失败", e);
            return null;
        }
    }

    @PostMapping
    @Override
    public void delKey(@RequestParam(value = "key") String key) {
        redisTemplate.delete(key);
    }
}
