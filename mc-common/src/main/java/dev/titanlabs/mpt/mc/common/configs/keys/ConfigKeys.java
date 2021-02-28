package dev.titanlabs.mpt.mc.common.configs.keys;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.configs.Config;
import dev.titanlabs.mpt.mc.common.configs.ConfigKey;
import dev.titanlabs.mpt.mc.common.configs.KeysHolder;

public class ConfigKeys extends KeysHolder {

    public ConfigKeys(MptPlatform platform) {
        super(Config.create(platform, "config.yml", (path) -> path));
    }

    public static final ConfigKey<Integer> CONFIG_VERSION = ConfigKey.of(KeysHolder::local, "config-version");
    public static final ConfigKey<String> TEST = ConfigKey.of(KeysHolder::local, "test");
}
