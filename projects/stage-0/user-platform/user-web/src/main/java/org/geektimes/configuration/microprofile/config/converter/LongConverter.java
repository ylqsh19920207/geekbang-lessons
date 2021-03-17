package org.geektimes.configuration.microprofile.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * @author xuxi
 * @date 2021/3/17
 * @description
 */
public class LongConverter implements Converter<Long> {

    @Override
    public Long convert(String s) throws IllegalArgumentException, NullPointerException {
        return Long.valueOf(s);
    }
}
