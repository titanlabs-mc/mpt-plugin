package dev.titanlabs.mpt.mc.bukkit;

import dev.titanlabs.mpt.mc.bukkit.command.BukkitCommandSender;
import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.MptPlugin;
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
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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
