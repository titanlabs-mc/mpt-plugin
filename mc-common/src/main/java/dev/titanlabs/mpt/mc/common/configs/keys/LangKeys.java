package dev.titanlabs.mpt.mc.common.configs.keys;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.configs.Config;
import dev.titanlabs.mpt.mc.common.configs.ConfigKey;
import dev.titanlabs.mpt.mc.common.configs.KeysHolder;

public class LangKeys extends KeysHolder {

    public LangKeys(MptPlatform platform) {
        super(Config.create(platform, "lang.yml", (path) -> path));
    }

    public static final ConfigKey<String> TEST = ConfigKey.of(KeysHolder::local, "test");
}
