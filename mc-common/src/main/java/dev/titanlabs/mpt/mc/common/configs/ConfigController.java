package dev.titanlabs.mpt.mc.common.configs;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.configs.keys.ConfigKeys;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ConfigController {
    private final MptPlatform platform;
    private final Map<String, Config> configs = new HashMap<>();

    public ConfigController(MptPlatform platform) {
        this.platform = platform;
        this.registerConfig(
                new ConfigKeys(platform)
        );
    }

    public CompletableFuture<Void> reload(String name) {
        return this.configs.get(name).reload(this.platform);
    }

    private void registerConfig(KeysHolder... keyHolders) {
        for (KeysHolder keysHolder : keyHolders) {
            Config config = keysHolder.getConfig();
            this.configs.put(config.getName(), config);
        }
    }
}
