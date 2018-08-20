package org.smart4j.chapter3.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by wangbin10 on 2018/8/20.
 */
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 将POJO转化成json
     */
    public static <T> String toJson(T obj) {
        String json = null;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 将json转化成POJO
     */
    public static <T> T fromJson(String json, Class<?> type) {
        T pojo = null;
        try {
            OBJECT_MAPPER.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pojo;
    }
}

