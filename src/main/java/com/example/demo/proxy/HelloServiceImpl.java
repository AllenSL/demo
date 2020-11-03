package com.example.demo.proxy;

/**
 * @author ansonglin
 * @className HelloServiceImpl
 * @description TODO
 * @date 2020/10/10 19:17
 * @cersion 1.0
 **/
public class HelloServiceImpl implements HelloService{


        @Override
        public String say(String hello) {
    System.out.println("hello"+hello);
            return "hello"+hello;
        }

        @Override
        public String name(String name) {
            System.out.println("xiaoming"+name);
            return "xiaoming"+name;
        }

}
   