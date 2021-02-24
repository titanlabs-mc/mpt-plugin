package dev.titanlabs.mpt.mc.common.commands;

import dev.titanlabs.mpt.mc.common.commands.children.InstallCommand;
import dev.titanlabs.mpt.mc.common.commands.sender.CommandSender;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommandController {
    private final Set<Command> commands = new HashSet<>();

    private static final String PERMISSION = "mpt.admin";

    public CommandController() {
        this.registerCommands(
                new InstallCommand()
        );
    }

    public void executeCommand(CommandSender commandSender, String[] args) {
        if (!commandSender.hasPermission(PERMISSION)) {
            // TODO: send message
            return;
        }
        for (Command command : this.commands) {
            if (!command.isAlias(args[0])) {
                continue;
            }

        }
    }

    private void registerCommands(Command... commands) {
        this.commands.addAll(Arrays.asList(commands));
    }
}
