package com.example.demo.dubbo.consumer;

import com.example.demo.dubbo.framework.ProxyFactory;
import com.example.demo.dubbo.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String s = helloService.sayHello("3214");
        System.out.println(s);
    }
}
