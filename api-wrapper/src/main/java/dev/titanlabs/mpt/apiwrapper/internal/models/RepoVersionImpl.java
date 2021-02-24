package dev.titanlabs.mpt.apiwrapper.internal.models;

import dev.titanlabs.mpt.apiwrapper.api.models.RepoVersion;

public class RepoVersionImpl implements RepoVersion {
    private final int major;
    private final int minor;
    private final int bugfix;

    public RepoVersionImpl(String version) {
        String[] splitVersion = version.split("\\.");

        this.major = Integer.parseInt(splitVersion[0]);
        this.minor = Integer.parseInt(splitVersion[1]);
        this.bugfix = Integer.parseInt(splitVersion[2]);
    }

    @Override
    public int getMajor() {
        return this.major;
    }

    @Override
    public int getMinor() {
        return this.minor;
    }

    @Override
    public int getBugfix() {
        return this.bugfix;
    }

}
