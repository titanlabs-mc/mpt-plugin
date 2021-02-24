package dev.titanlabs.mpt.apiwrapper.internal.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class JsonUtils {

    public Set<String> convertArrayToSet(JsonArray jsonArray) {
        Set<String> list = new HashSet<>();
        for (JsonElement element : jsonArray) {
            list.add(element.getAsString());
        }
        return list;
    }
}
