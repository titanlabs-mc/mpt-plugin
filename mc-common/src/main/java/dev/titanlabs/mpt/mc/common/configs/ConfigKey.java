package dev.titanlabs.mpt.mc.common.configs;

import dev.titanlabs.mpt.mc.common.configs.keys.AbstractKeys;

import java.util.function.Supplier;

public class ConfigKey<T> implements Supplier<T> {
    private final Config config;
    private final String key;

    public ConfigKey(Config config, String key) {
        this.config = config;
        this.key = key;
    }

    public static <U> ConfigKey<U> of(AbstractKeys abstractKeys, String key) {
        return new ConfigKey<>(abstractKeys.getConfig(), key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get() {
        return (T) this.config.get(this.key);
    }
}
