package dev.titanlabs.mpt.apiwrapper.internal.models.resource;

import dev.titanlabs.mpt.apiwrapper.api.models.resource.ResourceUpdateFile;
import dev.titanlabs.mpt.apiwrapper.api.request.ApiRequest;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Set;

public class ResourceUpdateFileImpl implements ResourceUpdateFile {
    private final Set<String> minecraftVersions;
    private final String fileId;
    private final boolean requiresFileChanges;

    public ResourceUpdateFileImpl(Set<String> minecraftVersions, String fileId, boolean requiresFileChanges) {
        this.minecraftVersions = minecraftVersions;
        this.fileId = fileId;
        this.requiresFileChanges = requiresFileChanges;
    }

    @Override
    public ApiRequest<File> getFile() {
        return null;
    }

    @Nonnull
    @Override
    public Set<String> getMinecraftVersions() {
        return this.minecraftVersions;
    }

    @Nonnull
    @Override
    public String getFileId() {
        return this.fileId;
    }

    @Override
    public boolean doesRequireFileChanges() {
        return this.requiresFileChanges;
    }
}
