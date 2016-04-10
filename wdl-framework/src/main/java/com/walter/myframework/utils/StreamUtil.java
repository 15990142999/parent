package com.walter.myframework.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by wangdongliang on 16/4/9.
 */
public final class StreamUtil {

    public static String getString(InputStream inputStream){
        StringBuffer sb = new StringBuffer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("", e);
        }
        return sb.toString();
    }
}
