package dev.titanlabs.mpt.mc.common.configs.keys;

import dev.titanlabs.mpt.mc.common.configs.Config;
import dev.titanlabs.mpt.mc.common.configs.ConfigKey;

public class ConfigKeys extends AbstractKeys {

    public ConfigKeys() {
        super(Config.create("config.yml", (path) -> path));
    }

    public static final ConfigKey<Integer> CONFIG_VERSION = ConfigKey.of(local(), "config-version");
}
