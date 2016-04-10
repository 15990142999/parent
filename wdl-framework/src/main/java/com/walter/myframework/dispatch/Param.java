package com.walter.myframework.dispatch;

import com.walter.myframework.utils.CastUtil;

import java.util.Map;

/**
 * Created by wangdongliang on 16/4/9.
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap){
        this.paramMap = paramMap;
    }

    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }
}
