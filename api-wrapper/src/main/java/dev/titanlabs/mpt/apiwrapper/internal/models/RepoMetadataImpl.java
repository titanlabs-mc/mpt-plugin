package dev.titanlabs.mpt.apiwrapper.internal.models;

import dev.titanlabs.mpt.apiwrapper.api.models.RepoMetadata;
import dev.titanlabs.mpt.apiwrapper.api.models.RepoVersion;

public class RepoMetadataImpl implements RepoMetadata {
    private final RepoVersion repoVersion;
    private final int apiVersion;

    public RepoMetadataImpl(String repoVersion, int apiVersion) {
        this.repoVersion = new RepoVersionImpl(repoVersion);
        this.apiVersion = apiVersion;
    }

    @Override
    public RepoVersion getVersion() {
        return this.repoVersion;
    }

    @Override
    public int getApiVersion() {
        return this.apiVersion;
    }
}
