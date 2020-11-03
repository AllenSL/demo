package com.example.demo.dubbo.framework;

import com.example.demo.dubbo.protocol.http.HttpClient;
import com.example.demo.dubbo.provider.api.HelloService;
import com.example.demo.dubbo.registry.Register;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory<T> {

    public static <T>T getProxy(Class interfaecClass){

       return (T) Proxy.newProxyInstance(interfaecClass.getClassLoader(), new Class[]{interfaecClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient = new HttpClient();
                Invocation invocation = new Invocation(HelloService.class.getName(),"sayHello",new Object[]{"123456"},new Class[]{String.class});
                URL random = Register.random(interfaecClass.getName());
                return httpClient.post("localhost", 8080, invocation);
            }
        });
    }
}
