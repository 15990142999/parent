package com.walter.myframework.Helper;

import com.walter.myframework.annotation.Inject;
import com.walter.myframework.utils.ReflectionUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangdongliang on 16/4/9.
 */
public class IocHelper {
    static{
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (!beanMap.isEmpty()){
            for (Map.Entry<Class<?>, Object> entity : beanMap.entrySet()){
                Class<?> cls = entity.getKey();
                Object object = entity.getValue();

                Field []fields = cls.getDeclaredFields();
                for (Field field : fields){
                    if (field.isAnnotationPresent(Inject.class)){
                        Class<?> fieldClass = field.getType();
                        Object fieldObject = beanMap.get(fieldClass);
                        if (fieldObject != null){
                            ReflectionUtil.setField(object, field, fieldObject);
                        }
                    }
                }
            }
        }
    }
}
