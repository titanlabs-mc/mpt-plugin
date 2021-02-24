package dev.titanlabs.mpt.apiwrapper.api;

import dev.titanlabs.mpt.apiwrapper.api.models.resource.Resource;
import dev.titanlabs.mpt.apiwrapper.api.request.ApiRequest;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Set;

public interface MptClient {

    /**
     * This will retrieve a set of resources from the specified repositories.
     *
     * @param resourceId   The ID of the resource to search for e.g luckperms or battle-pass
     * @param repositories A list of repository URLs to search for the resource in.
     * @return {@link ApiRequest} wrapping a list of retrieved resources. The list will be empty if none were found.
     */
    @Nonnull
    ApiRequest<Set<Resource>> retrieveResource(String resourceId, Collection<String> repositories);
}
