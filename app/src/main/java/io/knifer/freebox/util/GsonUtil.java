package io.knifer.freebox.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public final class GsonUtil {

    private GsonUtil() {}

    private final static Gson gson = new GsonBuilder().create();

    public static String toJson(Object object){
        return gson.toJson(object);
    }

    public static <T> T fromJson(String objectStr, Class<T> clazz){
        return gson.fromJson(objectStr, clazz);
    }

    public static JsonElement toJsonTree(Object object) {
        return gson.toJsonTree(object);
    }
}
