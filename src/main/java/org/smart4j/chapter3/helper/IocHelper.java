package org.smart4j.chapter3.helper;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.chapter2.util.CollectionUtil;
import org.smart4j.chapter3.annotation.Inject;
import org.smart4j.chapter3.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by wangbin10 on 2018/8/17.
 * 依赖注入助手类
 */
public final class IocHelper {
    static {
        /**获取所有bean类和bean实例的映射关系*/
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            /**变量bean map*/
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                /**从bean map中获取bean类与bean实例*/
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                /**获取bean类的所有成员变量*/
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)) {
                    /**变量bean field*/
                    for (Field beanField : beanFields) {
                        /**判断当前field是否有Inject注解*/
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            /**在beanMap中获取bean Field对应实例*/
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                /**通过反射初始化bean Field的值*/
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}

