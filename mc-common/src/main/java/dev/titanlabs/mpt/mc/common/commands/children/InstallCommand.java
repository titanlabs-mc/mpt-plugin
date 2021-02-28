package dev.titanlabs.mpt.mc.common.commands.children;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.commands.Command;
import dev.titanlabs.mpt.mc.common.commands.sender.CommandSender;

public class InstallCommand extends Command {

    public InstallCommand(MptPlatform platform) {
        super(platform);
        this.aliases("install");
    }

    @Override
    public void onCommand(CommandSender commandSender, String[] args) {

    }
}
