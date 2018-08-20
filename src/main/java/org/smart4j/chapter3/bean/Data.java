package org.smart4j.chapter3.bean;

/**
 * Created by wangbin10 on 2018/8/20.
 * 返回数据对象
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
