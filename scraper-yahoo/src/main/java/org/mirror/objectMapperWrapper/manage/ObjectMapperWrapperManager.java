package org.mirror.objectMapperWrapper.manage;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mirror.mapper.ObjectMapperWrapper;
import org.mirror.objectMapperWrapper.JacksonObjectMapperWrapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectMapperWrapperManager {
    private Map<String, ObjectMapperWrapper> jsonObjectMapperWrappers;

    // Not being used currently...
    private Map<String, ObjectMapperWrapper> xmlObjectMapperWrappers;

    private ObjectMapperWrapperManager() {
        defaultInit();
    }

    private static ObjectMapperWrapperManager INSTANCE = new ObjectMapperWrapperManager();

    public void defaultInit(){
        jsonObjectMapperWrappers = new ConcurrentHashMap<>();
        jsonObjectMapperWrappers.put("jackson", new JacksonObjectMapperWrapper(new ObjectMapper()));
    }
    public static ObjectMapperWrapperManager getInstance() {return INSTANCE;}

    public ObjectMapperWrapper getJsonObjectMapperWrapper(String key) {
        return jsonObjectMapperWrappers.get(key);
    }
    public void addJsonObjectMapperWrapper(String key, ObjectMapperWrapper jsonObjectMapperWrapper) {
        jsonObjectMapperWrappers.put(key, jsonObjectMapperWrapper);
    }
}
