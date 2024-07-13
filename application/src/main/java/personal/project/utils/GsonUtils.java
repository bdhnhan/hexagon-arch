package personal.project.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GsonUtils {

    private static final Gson gson = new Gson();

    public static <T> String toJsonString(T obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return "";
        }
    }

    public static <T> T fromJsonString(String json, Class<T> clazz, T defaultValue) {
        try {
            return gson.fromJson(json, clazz);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return defaultValue;
        }
    }
}
