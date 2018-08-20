package org.smart4j.chapter3.bean;

import java.util.Map;

/**
 * Created by wangbin10 on 2018/8/20.
 * 返回视图对象
 */
public class View {
    /**
     * 视图路径
     */
    private String path;
    /**
     * 模型对象
     */
    private Map<String, Object> model;

    public View(String path, Map<String, Object> model) {
        this.path = path;
        this.model = model;
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
