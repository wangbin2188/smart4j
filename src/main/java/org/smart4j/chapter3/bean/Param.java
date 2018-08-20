package org.smart4j.chapter3.bean;

import org.smart4j.chapter2.util.CastUtil;

import java.util.Map;

/**
 * Created by wangbin10 on 2018/8/20.
 * 请求参数对象
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有参数信息
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }
}
