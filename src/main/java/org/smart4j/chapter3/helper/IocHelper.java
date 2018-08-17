package org.smart4j.chapter3.helper;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.chapter2.util.CollectionUtil;
import org.smart4j.chapter3.annotation.Inject;
import org.smart4j.chapter3.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by wangbin10 on 2018/8/17.
 */
public final class IocHelper {
    static {
        /**获取所有bean类和bean实例的映射关系*/
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                /**获取bean类的所有成员变量*/
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}

