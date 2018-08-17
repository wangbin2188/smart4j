package org.smart4j.chapter3.helper;

import org.smart4j.chapter3.ConfigHelper;
import org.smart4j.chapter3.annotation.Controller;
import org.smart4j.chapter3.annotation.Service;
import org.smart4j.chapter3.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangbin10 on 2018/8/17.
 */
public final class ClassHelper {
    /**
     * 定义类集合，用于存储所加载的类
     */
    public static final Set<Class<?>> CLASS_SET;

    /**获取应用包名下所有类*/
    static {
        String appBasePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(appBasePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有Service类
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : classSet) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有Controller类
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : classSet) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有Bean类（包括Service，Controller）
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }
}
