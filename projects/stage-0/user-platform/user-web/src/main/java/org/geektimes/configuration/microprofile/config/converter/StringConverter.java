package org.geektimes.configuration.microprofile.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * @author xuxi
 * @date 2021/3/17
 * @description
 */
public class StringConverter implements Converter<String> {

    @Override
    public String convert(String s) throws IllegalArgumentException, NullPointerException {
        return s;
    }
}
