package dev.titanlabs.mpt.apiwrapper.internal;

import dev.titanlabs.mpt.apiwrapper.api.MptClient;
import dev.titanlabs.mpt.apiwrapper.api.models.resource.Resource;
import dev.titanlabs.mpt.apiwrapper.api.request.ApiRequest;

import java.util.Collection;
import java.util.Set;

public class MptClientImpl implements MptClient {

    @Override
    public ApiRequest<Set<Resource>> retrieveResource(String resourceId, Collection<String> repositories) {
        return null;
    }
}
