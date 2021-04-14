package org.geektimes.cache.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.RedisCodec;
import org.geektimes.cache.AbstractCacheManager;

import javax.cache.Cache;
import javax.cache.configuration.Configuration;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.util.Properties;

/**
 * @author xuxi
 * @date 2021/4/14
 * @description
 */
public class LettuceCacheManager extends AbstractCacheManager {

    private final RedisClient redisClient;

    private final RedisCodec redisCodec;

    public LettuceCacheManager(CachingProvider cachingProvider, URI uri, ClassLoader classLoader, Properties properties, RedisCodec redisCodec) {
        super(cachingProvider, uri, classLoader, properties);
        this.redisClient = RedisClient.create(uri.toString());
        this.redisCodec = redisCodec;
    }


    @Override
    protected <K, V, C extends Configuration<K, V>> Cache doCreateCache(String cacheName, C configuration) {
        StatefulRedisConnection<K, V> connect = redisClient.connect(redisCodec);
        return new LettuceCache(this, cacheName, configuration, connect);
    }

    @Override
    protected void doClose() {
        redisClient.shutdown();
    }
}
