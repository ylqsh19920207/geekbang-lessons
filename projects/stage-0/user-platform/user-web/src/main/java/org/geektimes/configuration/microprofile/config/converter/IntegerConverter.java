package org.geektimes.configuration.microprofile.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * @author xuxi
 * @date 2021/3/17
 * @description
 */
public class IntegerConverter implements Converter<Integer> {

    @Override
    public Integer convert(String s) throws IllegalArgumentException, NullPointerException {
        return Integer.valueOf(s);
    }
}
