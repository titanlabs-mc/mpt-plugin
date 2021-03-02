package dev.titanlabs.mpt.mc.common.commands.sender;

public interface MptCommandSender {

    void sendMessage(String message);

    boolean hasPermission(String permission);
}
