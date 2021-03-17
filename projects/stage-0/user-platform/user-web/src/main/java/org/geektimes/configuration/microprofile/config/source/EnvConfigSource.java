package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Map;
import java.util.Set;

/**
 * @author xuxi
 * @date 2021/3/17
 * @description
 */
public class EnvConfigSource implements ConfigSource {


    private final Map<String, String> properties;

    public EnvConfigSource() {
        this.properties = System.getenv();
    }

    @Override
    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    @Override
    public String getValue(String s) {
        return properties.get(s);
    }

    @Override
    public String getName() {
        return "OS Env Properties";
    }
}
