package dev.titanlabs.mpt.apiwrapper.api.models.resource;

import dev.titanlabs.mpt.apiwrapper.api.request.ApiRequest;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Set;

public interface ResourceUpdateFile {

    @Nonnull
    Set<String> getMinecraftVersions();

    @Nonnull
    String getFileId();

    boolean doesRequireFileChanges();

    @Nonnull
    ApiRequest<File> getFile();
}
