package com.example.demo.dubbo.provider;

import com.example.demo.dubbo.framework.URL;
import com.example.demo.dubbo.protocol.http.HttpServer;
import com.example.demo.dubbo.provider.api.HelloService;
import com.example.demo.dubbo.provider.impl.HelloServiceImpl;
import com.example.demo.dubbo.registry.Register;

public class Provider {

    public static void main(String[] args) {
        //注册服务

        URL url = new URL("localhost", 8080);
        Register.register(url, HelloService.class.getName(), HelloServiceImpl.class);

        //启动tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(), url.getPort());
    }
}
