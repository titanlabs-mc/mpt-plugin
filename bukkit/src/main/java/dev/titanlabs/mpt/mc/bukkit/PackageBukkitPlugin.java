package dev.titanlabs.mpt.mc.bukkit;

import dev.titanlabs.mpt.mc.bukkit.command.BukkitCommandSender;
import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.MptPlugin;
import dev.titanlabs.mpt.mc.common.configs.keys.ConfigKeys;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class PackageBukkitPlugin extends JavaPlugin implements MptPlugin {
    private final MptPlatform platform;

    public PackageBukkitPlugin() {
        this.platform = new MptPlatform();
    }

    @Override
    public void onEnable() {
        int configVersion = ConfigKeys.CONFIG_VERSION.get(); // testing
        System.out.println(configVersion);
        String test = ConfigKeys.TEST.get();
        System.out.println(test);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public MptPlatform getPlatform() {
        return this.platform;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        this.platform.getCommandController().executeCommand(new BukkitCommandSender(sender), args);
        return true;
    }
}
