package dev.titanlabs.mpt.mc.common.commands.sender;

public interface CommandSender {

    void sendMessage(String message);

    boolean hasPermission(String permission);
}
