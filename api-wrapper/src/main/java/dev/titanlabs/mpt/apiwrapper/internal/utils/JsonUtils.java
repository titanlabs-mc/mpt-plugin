package dev.titanlabs.mpt.apiwrapper.internal.utils;

import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.experimental.UtilityClass;

import java.util.Set;

@UtilityClass
public class JsonUtils {

    public Set<String> convertArrayToSet(JsonArray jsonArray) {
        Set<String> list = Sets.newHashSet();
        for (JsonElement element : jsonArray) {
            list.add(element.getAsString());
        }
        return list;
    }
}
