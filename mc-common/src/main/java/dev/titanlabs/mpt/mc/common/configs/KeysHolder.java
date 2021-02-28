package dev.titanlabs.mpt.mc.common.configs;

public class KeysHolder {
    private final Config config;

    private static KeysHolder instance;

    public KeysHolder(Config config) {
        this.config = config;
        instance = this;
    }

    protected static KeysHolder local() {
        return instance;
    }

    public Config getConfig() {
        return this.config;
    }
}
