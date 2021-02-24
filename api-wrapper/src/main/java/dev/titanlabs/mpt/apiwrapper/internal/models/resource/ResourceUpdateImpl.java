package dev.titanlabs.mpt.apiwrapper.internal.models.resource;

import dev.titanlabs.mpt.apiwrapper.api.models.resource.ResourceUpdate;
import dev.titanlabs.mpt.apiwrapper.api.models.resource.ResourceUpdateFile;

import javax.annotation.Nonnull;
import java.util.Set;

public class ResourceUpdateImpl implements ResourceUpdate {
    private final long releaseTime;
    private final String version;
    private final Set<ResourceUpdateFile> resourceUpdateFiles;

    public ResourceUpdateImpl(long releaseTime, String version, Set<ResourceUpdateFile> resourceUpdateFiles) {
        this.releaseTime = releaseTime;
        this.version = version;
        this.resourceUpdateFiles = resourceUpdateFiles;
    }

    @Override
    public long getReleaseTime() {
        return this.releaseTime;
    }

    @Nonnull
    @Override
    public Set<ResourceUpdateFile> getFiles() {
        return this.resourceUpdateFiles;
    }

    @Nonnull
    @Override
    public String getVersion() {
        return this.version;
    }

}
