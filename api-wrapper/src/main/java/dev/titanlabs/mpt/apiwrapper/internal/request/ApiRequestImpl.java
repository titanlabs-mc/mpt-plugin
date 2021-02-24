package dev.titanlabs.mpt.apiwrapper.internal.request;

import dev.titanlabs.mpt.apiwrapper.api.MptClient;
import dev.titanlabs.mpt.apiwrapper.api.request.ApiRequest;

public class ApiRequestImpl<T> implements ApiRequest<T> {
    protected final MptClient client;
}
