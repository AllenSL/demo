package com.example.demo.proxy;

import java.lang.reflect.Proxy;

/**
 * @author ansonglin
 * @className Test
 * @description TODO
 * @date 2020/10/10 19:06
 * @cersion 1.0
 **/
public class Test {

    public static void main(String[] args) {
//      Proxy.newProxyInstance(HelloService.class.getClassLoader(),HelloService.class.getClass().getInterfaces(),My);
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(),
                helloService.getClass().getInterfaces(), new MyInvocationHandler(helloService));
        proxy.name("HAHA");
        proxy.say("nihao");
    }
}
   