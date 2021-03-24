package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

/**
 * @author xuxi
 * @date 2021/3/17
 * @description
 */
public class LocalPropertirsConfigSource implements ConfigSource {

    public static final String PROPERTTIES_CONFIG_PATH = "/META-INF/microprofile-config.properties";

    private final Map<String, String> properties;

    public LocalPropertirsConfigSource() {
        Properties properties = new Properties();
        InputStream inputStream = Optional.ofNullable(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTTIES_CONFIG_PATH))
                .orElse(LocalPropertirsConfigSource.class.getResourceAsStream(PROPERTTIES_CONFIG_PATH));

        try {
            if (null != inputStream) {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            System.out.println("load " + PROPERTTIES_CONFIG_PATH + " properties fail ");
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Map<String, String> propertiesMap = new HashMap<>(16);
        for (String propertyName : properties.stringPropertyNames()) {
            propertiesMap.put(propertyName, properties.getProperty(propertyName));
        }
        this.properties = Collections.unmodifiableMap(propertiesMap);
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    @Override
    public int getOrdinal() {
        return 200;
    }

    @Override
    public String getValue(String s) {
        return properties.get(s);
    }

    @Override
    public String getName() {
        return "Application Local Properties";
    }
}
