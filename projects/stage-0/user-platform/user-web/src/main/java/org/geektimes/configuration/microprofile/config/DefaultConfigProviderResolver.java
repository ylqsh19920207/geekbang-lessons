package org.geektimes.configuration.microprofile.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigBuilder;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;

import java.util.Iterator;
import java.util.ServiceLoader;

public class DefaultConfigProviderResolver extends ConfigProviderResolver {

    private static volatile Config config = null;

    @Override
    public Config getConfig() {
        return getConfig(null);
    }

    @Override
    public Config getConfig(ClassLoader loader) {
        if (config == null) {
            synchronized (DefaultConfigProviderResolver.class) {
                if (config != null) {
                    return config;
                }
                ClassLoader classLoader = loader;
                if (classLoader == null) {
                    classLoader = Thread.currentThread().getContextClassLoader();
                }
                ServiceLoader<Config> serviceLoader = ServiceLoader.load(Config.class, classLoader);
                Iterator<Config> iterator = serviceLoader.iterator();
                if (iterator.hasNext()) {
                    // 获取 Config SPI 第一个实现
                    config = iterator.next();
                    return config;
                }
                throw new IllegalStateException("No Config implementation found!");
            }
        }
        return config;
    }

    @Override
    public ConfigBuilder getBuilder() {
        return null;
    }

    @Override
    public void registerConfig(Config config, ClassLoader classLoader) {

    }

    @Override
    public void releaseConfig(Config config) {

    }
}
