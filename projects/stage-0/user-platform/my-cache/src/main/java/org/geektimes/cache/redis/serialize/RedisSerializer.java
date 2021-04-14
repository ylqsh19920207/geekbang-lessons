package org.geektimes.cache.redis.serialize;

/**
 * @author xuxi
 * @date 2021/4/14
 * @description
 */
public interface RedisSerializer<T> {

    byte[] serialize(T t);

    T deSerialize(byte[] bytes);

}
