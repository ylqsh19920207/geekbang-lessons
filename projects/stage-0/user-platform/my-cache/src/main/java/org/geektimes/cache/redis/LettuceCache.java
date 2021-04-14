package org.geektimes.cache.redis;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.geektimes.cache.AbstractCache;
import org.geektimes.cache.ExpirableEntry;

import javax.cache.CacheException;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import java.io.Serializable;
import java.util.Set;

/**
 * @author xuxi
 * @date 2021/4/14
 * @description
 */
public class LettuceCache<K extends Serializable, V extends Serializable> extends AbstractCache<K, V> {

    private final StatefulRedisConnection<K, V> connect;

    private final RedisCommands<K, V> syncCommands;

    public LettuceCache(CacheManager cacheManager, String cacheName, Configuration<K, V> configuration, StatefulRedisConnection<K, V> connect) {
        super(cacheManager, cacheName, configuration);
        this.connect = connect;
        this.syncCommands = connect.sync();
    }

    @Override
    protected boolean containsEntry(K key) throws CacheException, ClassCastException {

        return 1L == syncCommands.exists(key);
    }

    @Override
    protected ExpirableEntry<K, V> getEntry(K key) throws CacheException, ClassCastException {
        return ExpirableEntry.of(key, syncCommands.get(key));
    }

    @Override
    protected void putEntry(ExpirableEntry<K, V> entry) throws CacheException, ClassCastException {
        syncCommands.set(entry.getKey(), entry.getValue());
    }

    @Override
    protected ExpirableEntry<K, V> removeEntry(K key) throws CacheException, ClassCastException {
        ExpirableEntry<K, V> entry = getEntry(key);
        syncCommands.del(key);
        return entry;
    }

    @Override
    protected void clearEntries() throws CacheException {
        //TODO
    }

    @Override
    protected Set<K> keySet() {
        //TODO
        return null;
    }

    @Override
    protected void doClose() {
        this.connect.close();
    }
}
