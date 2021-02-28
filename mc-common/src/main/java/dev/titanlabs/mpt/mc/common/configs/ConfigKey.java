package dev.titanlabs.mpt.mc.common.configs;

import java.util.function.Supplier;

public class ConfigKey<T> implements Supplier<T> {
    private final Supplier<KeysHolder> keysHolder;
    private final String key;

    public ConfigKey(Supplier<KeysHolder> keysHolder, String key) {
        this.keysHolder = keysHolder;
        this.key = key;
    }

    public static <U> ConfigKey<U> of(Supplier<KeysHolder> keysHolder, String key) {
        return new ConfigKey<>(keysHolder, key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get() {
        return (T) this.keysHolder.get().getConfig().get(this.key);
    }
}
