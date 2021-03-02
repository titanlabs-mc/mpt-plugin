package dev.titanlabs.mpt.mc.common.commands.children;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.commands.Command;
import dev.titanlabs.mpt.mc.common.commands.sender.MptCommandSender;
import dev.titanlabs.mpt.mc.common.enums.Flag;

public class InstallCommand extends Command {

    public InstallCommand(MptPlatform platform) {
        super(platform);
        this.aliases("install");
        this.argument("package name", (arg) -> {
            return "hello";
        });
        this.flags(Flag.VERBOSE);
    }

    @Override
    public void onCommand(MptCommandSender commandSender, String[] args) {
        String packageName = this.readArgument("package name", args);
    }
}
