package com.walter.myframework.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangdongliang on 16/4/7.
 */
public final class ReflectionUtil {

    public static Object newInstance(Class<?> cls){
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法.
     */
    public static Object invokeMethod(Object object, Method method, Object ...args){
        Object result;

        try {
            method.setAccessible(true);
            result = method.invoke(object, args);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }

    /**
     * 设置成员变量的值.
     */
    public static void setField(Object object, Field field, Object value){

        try {
            field.setAccessible(true);
            field.set(object, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
