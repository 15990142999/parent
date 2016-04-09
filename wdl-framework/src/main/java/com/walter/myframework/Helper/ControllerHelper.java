package com.walter.myframework.Helper;

import com.walter.myframework.annotation.Action;
import com.walter.myframework.controller.Handler;
import com.walter.myframework.controller.Request;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangdongliang on 16/4/9.
 */
public final class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

    static {

        Set<Class<?>> classSet = ClassHelper.getControllerClassSet();
        if (!classSet.isEmpty()){
            for (Class<?> controllerClass : classSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                for (Method method: methods){
                    if (method.isAnnotationPresent(Action.class)){
                        Action action = method.getAnnotation(Action.class);
                        String mapping = action.value();
                        //verify url mapping rule
                        if (mapping.matches("\\w+:/\\w*")){
                            String []array = mapping.split(":");

                            String requestMethod = array[0];
                            String reqeustPath = array[1];

                            Request request = new Request(requestMethod, reqeustPath);
                            Handler handler = new Handler(controllerClass, method);

                            ACTION_MAP.put(request, handler);
                        }
                    }
                }
            }
        }

    }


    public static Handler getHandler(String requestMethod, String requestPath){
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }


}
