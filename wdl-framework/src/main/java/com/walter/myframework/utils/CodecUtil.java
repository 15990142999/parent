package com.walter.myframework.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by wangdongliang on 16/4/9.
 */
public final class CodecUtil {

    public static String encodeURL(String source){
        String target;

        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("encode url failed", e);
        }

        return target;
    }


    public static String decodeURL(String source){
        String target;

        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("decode url failed", e);
        }

        return target;
    }


}
