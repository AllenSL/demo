package com.example.demo.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理测试类
 */
public class Test {

    public static void main(String[] args) {
        Secretary secretary = new Secretary();
        Function function =
                (Function)
                        Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{Function.class}, secretary);
        function.eatFood();
    }
}
