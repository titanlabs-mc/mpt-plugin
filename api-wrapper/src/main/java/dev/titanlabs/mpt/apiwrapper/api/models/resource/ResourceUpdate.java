package dev.titanlabs.mpt.apiwrapper.api.models.resource;


import javax.annotation.Nonnull;
import java.util.Set;

public interface ResourceUpdate extends Comparable<ResourceUpdate> {

    long getReleaseTime();

    @Nonnull
    String getVersion();

    @Nonnull
    Set<ResourceUpdateFile> getFiles();

    @Override
    default int compareTo(@Nonnull ResourceUpdate o) {
        return Long.compare(o.getReleaseTime(), this.getReleaseTime());
    }
}
