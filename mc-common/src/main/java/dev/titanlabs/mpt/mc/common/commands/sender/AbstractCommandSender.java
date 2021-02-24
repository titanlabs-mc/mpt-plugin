package dev.titanlabs.mpt.mc.common.commands.sender;

public abstract class AbstractCommandSender<T> implements CommandSender {
    protected final T delegate;

    public AbstractCommandSender(T delegate) {
        this.delegate = delegate;
    }
}
