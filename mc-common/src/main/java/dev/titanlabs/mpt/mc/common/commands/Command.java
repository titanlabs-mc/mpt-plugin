package dev.titanlabs.mpt.mc.common.commands;

import dev.titanlabs.mpt.mc.common.commands.arguments.Argument;
import dev.titanlabs.mpt.mc.common.commands.sender.CommandSender;

import java.util.*;

public abstract class Command {
    private final Set<String> aliases = new LinkedHashSet<>();
    private final List<Argument> arguments = new ArrayList<>();

    public void aliases(String... aliases) {
        this.aliases.addAll(Arrays.asList(aliases));
    }

    public boolean isAlias(String alias) {
        return this.aliases.contains(alias);
    }

    public abstract void onCommand(CommandSender commandSender, String[] args);
}
