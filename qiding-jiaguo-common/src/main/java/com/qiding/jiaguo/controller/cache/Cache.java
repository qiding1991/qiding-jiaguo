package com.qiding.jiaguo.controller.cache;

public interface Cache {

    /**
     * 缓存值
     * @param key 关键字
     * @param value 值
     * @param <T>
     */
    <T> void cacheKey(String key, T value);


    /**
     * 缓存值过期时间
     * @param key 关键字
     * @param value 值
     * @param cacheTime 缓存时间
     * @param <T>
     */
    <T> void cacheKeyWithEx(String key, T value,Long cacheTime);


    /**
     * 缓存值过期时间
     * @param key 关键字
     * @param value 值
     * @param expireTime 缓存时间
     * @param <T>
     */
    <T> void cacheKeyWithAt(String key, T value, Long expireTime);

    /**
     * 获取缓存的值
     * @param key
     * @param <T>
     * @return
     */
    <T> T getValue(String key,String className);

    /**
     * 删除值
     * @param key
     */
    void delKey(String key);

}
