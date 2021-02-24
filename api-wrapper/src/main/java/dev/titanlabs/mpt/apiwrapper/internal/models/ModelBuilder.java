package dev.titanlabs.mpt.apiwrapper.internal.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.titanlabs.mpt.apiwrapper.api.MptClient;
import dev.titanlabs.mpt.apiwrapper.api.models.resource.ResourceUpdate;
import dev.titanlabs.mpt.apiwrapper.api.models.resource.ResourceUpdateFile;
import dev.titanlabs.mpt.apiwrapper.internal.models.resource.ResourceImpl;
import dev.titanlabs.mpt.apiwrapper.internal.models.resource.ResourceUpdateFileImpl;
import dev.titanlabs.mpt.apiwrapper.internal.models.resource.ResourceUpdateImpl;
import dev.titanlabs.mpt.apiwrapper.internal.utils.JsonUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ModelBuilder {
    private final MptClient mptClient;

    public ModelBuilder(MptClient mptClient) {
        this.mptClient = mptClient;
    }

    public ResourceImpl createResource(String repository, JsonObject jsonObject) {
        String identifier = jsonObject.get("identifier").getAsString();
        String name = jsonObject.get("name").getAsString();
        int spigotId = jsonObject.has("spigotId") ? jsonObject.get("spigotId").getAsInt() : -1;
        int spigotAuthorId = jsonObject.has("spigotAuthorId") ? jsonObject.get("spigotAuthorId").getAsInt() : -1;
        Set<String> dependencyIds = JsonUtils.convertArrayToSet(jsonObject.get("dependencyIds").getAsJsonArray());
        List<ResourceUpdate> resourceUpdates = StreamSupport.stream(jsonObject.get("updates").getAsJsonArray().spliterator(), false)
                .map(JsonElement::getAsJsonObject)
                .map(this::createResourceUpdate)
                .collect(Collectors.toList());
        return new ResourceImpl(repository, identifier, name, resourceUpdates, spigotId, spigotAuthorId, dependencyIds);
    }

    private ResourceUpdateImpl createResourceUpdate(JsonObject jsonObject) {
        long releaseTime = jsonObject.get("releaseTime").getAsLong();
        String version = jsonObject.get("version").getAsString();
        Set<ResourceUpdateFile> resourceUpdateFiles = StreamSupport.stream(jsonObject.get("files").getAsJsonArray().spliterator(), false)
                .map(JsonElement::getAsJsonObject)
                .map(this::createResourceUpdateFile)
                .collect(Collectors.toSet());
        return new ResourceUpdateImpl(releaseTime, version, resourceUpdateFiles);
    }

    private ResourceUpdateFileImpl createResourceUpdateFile(JsonObject jsonObject) {
        Set<String> minecraftVersions = JsonUtils.convertArrayToSet(jsonObject.get("minecraftVersions").getAsJsonArray());
        String fileId = jsonObject.get("fileId").getAsString();
        boolean requiresFileChanges = jsonObject.get("requiresFileChanges").getAsBoolean();
        return new ResourceUpdateFileImpl(minecraftVersions, fileId, requiresFileChanges);
    }
}
