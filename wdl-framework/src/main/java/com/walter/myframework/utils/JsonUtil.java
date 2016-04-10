package com.walter.myframework.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by wangdongliang on 16/4/11.
 */
public final class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * transfer POJO to JSON
     */
    public static <T> String toJson(T obj){
        String json;

        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return json;
    }

    /**
     * transfer JSON to POJO
     */
    public static <T> T fromJson(String json, Class<T> type){
        T pojo;

        try {
            pojo = OBJECT_MAPPER.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return pojo;
    }
}
