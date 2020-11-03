package com.example.demo.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理boss类
 */
public class Secretary implements InvocationHandler {
    Boss boss = new Boss();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("预约Boss");
        Object invoke = method.invoke(boss,args);
        System.out.println("用餐结束，备注");
        return invoke;
    }
}
