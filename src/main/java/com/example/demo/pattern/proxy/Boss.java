package com.example.demo.pattern.proxy;

public class Boss implements Function{

    @Override
    public void eatFood() {
        System.out.println("Boss开始吃饭");
    }
}
