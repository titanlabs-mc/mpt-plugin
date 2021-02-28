package dev.titanlabs.mpt.mc.common.commands;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.commands.arguments.Argument;
import dev.titanlabs.mpt.mc.common.commands.sender.CommandSender;

import java.util.*;

public abstract class Command {
    protected final MptPlatform platform;
    private final Set<String> aliases = new LinkedHashSet<>();
    private final List<Argument> arguments = new ArrayList<>();

    public Command(MptPlatform platform) {
        this.platform = platform;
    }

    public void aliases(String... aliases) {
        this.aliases.addAll(Arrays.asList(aliases));
    }

    public boolean isAlias(String alias) {
        return this.aliases.contains(alias);
    }

    public abstract void onCommand(CommandSender commandSender, String[] args);
}
