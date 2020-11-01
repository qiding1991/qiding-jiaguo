package com.qiding.jiaguo.user.service;

import com.qiding.jiaguo.common.controller.cache.Cache;

public class UserCacheService implements Cache {

    @Override
    public <T> void cacheKey(String key, T value) {

    }

    @Override
    public <T> void cacheKeyWithEx(String key, T value, Long cacheTime) {

    }

    @Override
    public <T> void cacheKeyWithAt(String key, T value, Long expireTime) {

    }

    @Override
    public <T> T getValue(String key, String className) {
        return null;
    }

    @Override
    public void delKey(String key) {

    }
}
