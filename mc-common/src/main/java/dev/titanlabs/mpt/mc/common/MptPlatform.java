package dev.titanlabs.mpt.mc.common;

import dev.titanlabs.mpt.mc.common.commands.CommandController;
import dev.titanlabs.mpt.mc.common.concurrency.Scheduler;
import dev.titanlabs.mpt.mc.common.configs.ConfigController;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class MptPlatform {
    private final Path dataFolder;
    private final Scheduler scheduler;
    private final CommandController commandController;
    private final ConfigController configController;

    public MptPlatform() {
        this.dataFolder = this.createDataFolder();
        this.scheduler = new Scheduler();
        this.commandController = new CommandController(this);
        this.configController = new ConfigController(this);
    }

    public Path getDataFolder() {
        return this.dataFolder;
    }

    public Scheduler scheduler() {
        return this.scheduler;
    }

    public CommandController getCommandController() {
        return this.commandController;
    }

    public ConfigController getConfigController() {
        return this.configController;
    }

    @SneakyThrows
    private Path createDataFolder() {
        String absolutePlatformPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        String platformPath = absolutePlatformPath.substring(0, absolutePlatformPath.lastIndexOf(File.separator));
        Path dataFolder = new File(platformPath).toPath().resolve("MinecraftPackageTool");
        if (!Files.exists(dataFolder)) {
            dataFolder.toFile().mkdirs();
        }
        return dataFolder;
    }
}
