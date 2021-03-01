package dev.titanlabs.mpt.mc.common.commands.arguments;

import java.util.function.Function;

public class Argument {
    private final String name;
    private final int index;
    private final Function<String, ?> resolver;

    public Argument(String name, int index, Function<String, ?> resolver) {
        this.name = name;
        this.index = index;
        this.resolver = resolver;
    }

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }

    @SuppressWarnings("unchecked")
    public <T> T resolve(String arg) {
        return (T) this.resolver.apply(arg);
    }
}
