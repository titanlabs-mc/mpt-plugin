package dev.titanlabs.mpt.mc.common.commands;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.commands.children.InstallCommand;
import dev.titanlabs.mpt.mc.common.commands.children.ReloadCommand;
import dev.titanlabs.mpt.mc.common.commands.sender.MptCommandSender;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommandController {
    private final MptPlatform platform;
    private final Set<Command> commands = new HashSet<>();

    private static final String PERMISSION = "mpt.admin";

    public CommandController(MptPlatform platform) {
        this.platform = platform;
        this.registerCommands(
                new InstallCommand(platform),
                new ReloadCommand(platform)
        );
    }

    public void executeCommand(MptCommandSender commandSender, String[] args) {
        if (!commandSender.hasPermission(PERMISSION)) {
            // TODO: send message
            return;
        }
        for (Command command : this.commands) {
            if (!command.isAlias(args[0])) {
                continue;
            }
            command.onCommand(commandSender, args);
        }
    }

    private void registerCommands(Command... commands) {
        this.commands.addAll(Arrays.asList(commands));
    }
}
