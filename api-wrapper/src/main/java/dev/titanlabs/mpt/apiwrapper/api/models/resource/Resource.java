package dev.titanlabs.mpt.apiwrapper.api.models.resource;

import dev.titanlabs.mpt.apiwrapper.api.models.resource.interfaces.RemoteModel;
import dev.titanlabs.mpt.apiwrapper.api.request.ApiRequest;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Set;

public interface Resource extends RemoteModel {

    /**
     * The forced lower-case string identifier of the resource (e.g essentials or luckperms).
     *
     * @return String of the resource id.
     */
    @Nonnull
    String getIdentifier();

    /**
     * The name of the resource that's used for display or searching (e.g EssentialsX or LuckPerms).
     *
     * @return String of the resource name.
     */
    @Nonnull
    String getName();

    /**
     * Gets a current list of the resource's updates.
     * This list will be empty if there are no current versions.
     *
     * @return {@link ApiRequest} wrapping a list of {@link ResourceUpdate} for the resource.
     */
    @Nonnull
    List<ResourceUpdate> getUpdates();

    /**
     * The Spigot resource ID of the resource.
     * The ID will be -1 if there is no associated Spigot resource.
     *
     * @return Integer ID of the resource on Spigot or -1 if it is not specified.
     */
    int getSpigotId();

    /**
     * The Spigot resource author's ID.
     * The ID will be -1 if there is no associated Spigot author.
     *
     * @return Integer ID of the Spigot author or -1 if it is not specified.
     */
    int getSpigotAuthorId();

    /**
     * The listed dependencies of the resource.
     * The set will be empty if there are no dependencies.
     *
     * @return Set of String IDs of the resource's dependencies.
     */
    @Nonnull
    Set<String> getDependencyIds();
}
