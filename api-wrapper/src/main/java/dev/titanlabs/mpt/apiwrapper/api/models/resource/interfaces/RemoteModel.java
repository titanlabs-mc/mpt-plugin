package dev.titanlabs.mpt.apiwrapper.api.models.resource.interfaces;

import javax.annotation.Nonnull;

public interface RemoteModel {

    /**
     * The repository URL the model was retrieved from.
     *
     * @return String of the repository URL (e.g https://repo.mpt.titanlabs.dev/)
     */
    @Nonnull
    String getRepository();
}
