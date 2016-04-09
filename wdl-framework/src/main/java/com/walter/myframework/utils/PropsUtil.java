package com.walter.myframework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * 资源文件读取.
 * Created by wangdongliang on 16/4/7.
 */
public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName){

        Properties properties = null;

        //TWR in java7 and after that
        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)){
            properties = new Properties();
            properties.load(inputStream);

        }catch (IOException e){
            LOGGER.error("load properties file " + fileName +"failed, please check!" );
        }

        return properties;
    }


    public static String getString(Properties properties, String key){
        return getString(properties, key, "");
    }

    //写法,不建议return多次
    public static String getString(Properties properties, String key, String defaultValue){
        String value = defaultValue;
        if (properties.contains(key)){
            value = properties.getProperty(key);
        }
        return value;
    }
}
