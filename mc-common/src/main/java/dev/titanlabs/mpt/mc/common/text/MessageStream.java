package dev.titanlabs.mpt.mc.common.text;

import dev.titanlabs.mpt.mc.common.commands.sender.MptCommandSender;
import dev.titanlabs.mpt.mc.common.configs.ConfigKey;

public class MessageStream {
    private MptCommandSender target;

    public MessageStream(MptCommandSender target) {
        this.target = target;
    }

    public static MessageStream attach(MptCommandSender target) {
        return new MessageStream(target);
    }

    public void add(ConfigKey<String> configKey) {
        this.add(configKey.get());
    }

    public void add(String message) {
        this.target.sendMessage(Colorizer.color(message));
    }

    public void close() {
        this.target = null;
    }
}
