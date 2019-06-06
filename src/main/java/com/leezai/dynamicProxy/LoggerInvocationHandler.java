package com.leezai.dynamicProxy;

import com.leezai.annotation.RequireRoles;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggerInvocationHandler implements InvocationHandler {

    private Object receivedObject;

    public LoggerInvocationHandler(Object object) {
        this.receivedObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("code".equalsIgnoreCase(method.getName())) {
            System.out.println("start to call method:" + method.getName());
            Object result = method.invoke(receivedObject, args);
            System.out.println("complete the dynamic proxy");
            return result;
        }
        RequireRoles role = method.getAnnotation(RequireRoles.class);
        if (role != null) {
            System.out.println("Method "+method.getName()+" require Role :"+ Arrays.asList(role.value()));
            return method.invoke(receivedObject, args);
        }
        return method.invoke(receivedObject, args);
    }
}
