package com.walter.myframework.utils;

/**
 * Created by wangdongliang on 16/4/9.
 */
public final class CastUtil {

    public static long castLong(Object object){
        return castLong(object, 0);
    }

    public static long castLong(Object object, long defaultValue){
        long longValue = defaultValue;
        if (object !=null){
            String strValue = castString(object, "");
        }

        return longValue;
    }

    public static String castString(Object object, String defaultValue){
        String strValue = defaultValue;
        if (object != null){
            strValue = (String) object;
        }

        return strValue;
    }


}
