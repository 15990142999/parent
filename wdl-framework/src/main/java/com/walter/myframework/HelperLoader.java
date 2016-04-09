package com.walter.myframework;

import com.walter.myframework.Helper.BeanHelper;
import com.walter.myframework.Helper.ClassHelper;
import com.walter.myframework.Helper.ControllerHelper;
import com.walter.myframework.Helper.IocHelper;
import com.walter.myframework.utils.ClassUtil;

/**
 * Created by wangdongliang on 16/4/9.
 */
public final class HelperLoader {

    public static void init(){
        Class<?> [] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName(), false);
        }
    }
}
