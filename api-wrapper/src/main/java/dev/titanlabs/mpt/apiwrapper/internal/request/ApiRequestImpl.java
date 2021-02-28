package dev.titanlabs.mpt.apiwrapper.internal.request;

import dev.titanlabs.mpt.apiwrapper.api.MptClient;
import dev.titanlabs.mpt.apiwrapper.api.request.ApiRequest;

import java.util.function.Consumer;

public class ApiRequestImpl<T> implements ApiRequest<T> {
    protected final MptClient client;

    public ApiRequestImpl(MptClient client) {
        this.client = client;
    }

    @Override
    public MptClient getClient() {
        return null;
    }

    @Override
    public void execute(Consumer<T> successConsumer, Consumer<? extends Exception> failureConsumer) {

    }
}
