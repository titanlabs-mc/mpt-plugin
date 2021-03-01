package dev.titanlabs.mpt.mc.common.commands;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import dev.titanlabs.mpt.mc.common.commands.arguments.Argument;
import dev.titanlabs.mpt.mc.common.commands.sender.CommandSender;
import dev.titanlabs.mpt.mc.common.enums.Flag;

import java.util.*;
import java.util.function.Function;

public abstract class Command {
    protected final MptPlatform platform;
    private final Set<String> aliases = new LinkedHashSet<>();
    private final Map<String, Argument> arguments = new HashMap<>();
    private final Set<Flag> flags = new HashSet<>();

    public Command(MptPlatform platform) {
        this.platform = platform;
    }

    public void aliases(String... aliases) {
        this.aliases.addAll(Arrays.asList(aliases));
    }

    public void argument(String name) {
        this.argument(name, null);
    }

    public void argument(String name, Function<String, ?> resolver) {
        int index = this.arguments.size() + 1;
        this.arguments.put(name, new Argument(name, index, resolver));
    }

    public void flags(Flag... flags) {
        this.flags.addAll(Arrays.asList(flags));
    }

    public <T> T readArgument(String name, String[] args) {
        Argument argument = this.arguments.get(name);
        return argument.resolve(args[argument.getIndex()]);
    }

    public boolean hasFlag(Flag flag, String[] args) {
        for (String arg : args) {
            if (Flag.isFlag(arg) && flag.getFlag().equalsIgnoreCase(arg)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlias(String alias) {
        return this.aliases.contains(alias);
    }

    public abstract void onCommand(CommandSender commandSender, String[] args);
}
