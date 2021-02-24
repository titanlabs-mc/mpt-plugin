package dev.titanlabs.mpt.apiwrapper.api.request;

import dev.titanlabs.mpt.apiwrapper.api.MptClient;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Consumer;

public interface ApiRequest<T> {

    @Nonnull
    MptClient getClient();

    default void execute() {
        this.execute(null, null);
    }

    default void execute(Consumer<T> successConsumer) {
        this.execute(successConsumer, null);
    }

    void execute(@Nullable Consumer<T> successConsumer, @Nullable Consumer<? extends Exception> failureConsumer);
}
