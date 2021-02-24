package dev.titanlabs.mpt.apiwrapper.internal.models.resource;

import dev.titanlabs.mpt.apiwrapper.api.models.resource.Resource;
import dev.titanlabs.mpt.apiwrapper.api.models.resource.ResourceUpdate;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Set;

public class ResourceImpl implements Resource {
    private final String repository;
    private final String identifier;
    private final String name;
    private final List<ResourceUpdate> resourceUpdates;
    private final int spigotId;
    private final int spigotAuthorId;
    private final Set<String> dependencyIds;

    public ResourceImpl(String repository, String identifier, String name, List<ResourceUpdate> resourceUpdates, int spigotId, int spigotAuthorId, Set<String> dependencyIds) {
        this.repository = repository;
        this.identifier = identifier;
        this.name = name;
        this.resourceUpdates = resourceUpdates;
        this.spigotId = spigotId;
        this.spigotAuthorId = spigotAuthorId;
        this.dependencyIds = dependencyIds;
    }

    @NotNull
    @Override
    public String getRepository() {
        return this.repository;
    }

    @Nonnull
    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Nonnull
    @Override
    public String getName() {
        return this.name;
    }

    @Nonnull
    @Override
    public List<ResourceUpdate> getUpdates() {
        return this.resourceUpdates;
    }

    @Override
    public int getSpigotId() {
        return this.spigotId;
    }

    @Override
    public int getSpigotAuthorId() {
        return this.spigotAuthorId;
    }

    @Nonnull
    @Override
    public Set<String> getDependencyIds() {
        return this.dependencyIds;
    }
}
