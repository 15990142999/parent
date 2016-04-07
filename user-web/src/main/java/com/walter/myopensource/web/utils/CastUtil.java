package com.walter.myopensource.web.utils;

/**
 * Created by wangdongliang on 16/4/7.
 */
public final class CastUtil {

    public static String castString (Object obj){
        return castString(obj, "");
    }

    public static String castString (Object obj, String defaultValue){
        return obj != null ? String.valueOf(obj) : defaultValue;
    }
}
