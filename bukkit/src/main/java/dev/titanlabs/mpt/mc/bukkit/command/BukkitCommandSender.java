package dev.titanlabs.mpt.mc.bukkit.command;

import dev.titanlabs.mpt.mc.common.commands.sender.AbstractCommandSender;
import org.bukkit.command.CommandSender;

public class BukkitCommandSender extends AbstractCommandSender<CommandSender> {

    public BukkitCommandSender(CommandSender delegate) {
        super(delegate);
    }

    @Override
    public void sendMessage(String message) {
        this.delegate.sendMessage(message);
    }

    @Override
    public boolean hasPermission(String permission) {
        return this.delegate.hasPermission(permission);
    }
}
