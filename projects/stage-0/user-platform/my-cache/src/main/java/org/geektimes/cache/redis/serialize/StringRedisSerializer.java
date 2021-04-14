package org.geektimes.cache.redis.serialize;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author zige
 * @date 2021/4/14
 * @description
 */
public class StringRedisSerializer implements RedisSerializer<String> {

    private final Charset charset;

    public StringRedisSerializer() {
        this(StandardCharsets.UTF_8);
    }

    public StringRedisSerializer(Charset charset) {
        this.charset = charset;
    }


    @Override
    public byte[] serialize(String s) {
        return null == s ? null : s.getBytes(charset);
    }

    @Override
    public String deSerialize(byte[] bytes) {
        return null == bytes ? null : new String(bytes, charset);
    }
}
