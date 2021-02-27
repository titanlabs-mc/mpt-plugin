package dev.titanlabs.mpt.mc.common.configs.keys;

import dev.titanlabs.mpt.mc.common.configs.Config;

public class AbstractKeys {
    private final Config config;

    private static AbstractKeys instance;

    public AbstractKeys(Config config) {
        this.config = config;
        instance = this;
    }

    protected static AbstractKeys local() {
        return instance;
    }

    public Config getConfig() {
        return this.config;
    }
}
