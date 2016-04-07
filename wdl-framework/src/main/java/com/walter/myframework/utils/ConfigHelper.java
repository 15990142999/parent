package com.walter.myframework.utils;

import com.walter.myframework.constant.ConfigConstant;

import java.util.Properties;

/**
 * Created by wangdongliang on 16/4/7.
 */
public final class ConfigHelper {

    private static final Properties CONFIG_PROPERTIES = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_DRIVER);
    }


    public static String getJdbcUserName(){
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcUserPassword(){
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_PASSWORD);
    }

    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_BASE_PACKAGE);
    }

    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_JSP_PATH);
    }

    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_ASSET_PATH, "/asset/");
    }
}
