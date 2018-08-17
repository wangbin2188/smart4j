package org.smart4j.chapter3.helper;

import org.smart4j.chapter3.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangbin10 on 2018/8/17.
 */
public final class BeanHelper {
    /**
     * 用于存放Bean类与Bean实例的映射关系
     */
    public static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 通过Bean类获取Bean实例
     */
    public static <T> T getBean(Class<?> cls) {
        return (T) BEAN_MAP.get(cls);
    }
}
