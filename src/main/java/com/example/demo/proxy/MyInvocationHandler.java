package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ansonglin
 * @className MyInvocationHandler
 * @description TODO
 * @date 2020/10/10 18:56
 * @cersion 1.0
 **/
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    MyInvocationHandler(Object o){
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("pre Proxy"+proxy.getClass().getName());

        System.out.println("after aop");

        Object result = method.invoke(object, args);

        System.out.println("pre Proxy"+method.getName());
        return result;
    }
}
   