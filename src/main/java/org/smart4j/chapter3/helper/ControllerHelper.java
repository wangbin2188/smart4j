package org.smart4j.chapter3.helper;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.chapter2.util.CollectionUtil;
import org.smart4j.chapter3.annotation.Action;
import org.smart4j.chapter3.bean.Handler;
import org.smart4j.chapter3.bean.Request;
import org.smart4j.chapter3.util.ClassUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangbin10 on 2018/8/20.
 * 控制器助手类
 */
public final class ControllerHelper {
    /**
     * 用于存放请求与处理器的映射关系，简称Action Map
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

    static {
        /**获取所有的Controller类*/
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            /**遍历这些Controller类*/
            for (Class<?> controllerClass : controllerClassSet) {
                /**获取Controller类中定义的方法*/
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtils.isNotEmpty(methods)) {
                    /**遍历方法*/
                    for (Method method : methods) {
                        /**判断当前方法是否有Action注解*/
                        if (method.isAnnotationPresent(Action.class)) {
                            Action action = method.getAnnotation(Action.class);
                            /**从Action注解中获取URL映射规则*/
                            String mapping = action.value();
                            /**验证URL映射规则*/
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                                    /**获取请求方法与请求路径*/
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    /**初始化action map*/
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
