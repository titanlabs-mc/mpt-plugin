package dev.titanlabs.mpt.mc.common.commands.children;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.commands.Command;
import dev.titanlabs.mpt.mc.common.commands.sender.MptCommandSender;
import dev.titanlabs.mpt.mc.common.configs.keys.ConfigKeys;

public class ReloadCommand extends Command {

    public ReloadCommand(MptPlatform platform) {
        super(platform);
        this.aliases("reload");
    }

    @Override
    public void onCommand(MptCommandSender commandSender, String[] args) {
        System.out.println(ConfigKeys.TEST.get());
        this.platform.getConfigController().reload("config.yml").join();
        System.out.println(ConfigKeys.TEST.get());
    }
}
