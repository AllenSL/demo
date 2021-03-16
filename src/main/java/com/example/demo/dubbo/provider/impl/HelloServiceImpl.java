package com.example.demo.dubbo.provider.impl;

import com.example.demo.dubbo.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String userName) {
        return "userNmae:" + userName;
    }
}
