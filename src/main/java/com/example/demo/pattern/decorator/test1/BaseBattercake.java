package com.example.demo.pattern.decorator.test1;

public class BaseBattercake extends Battercake{
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected Integer getPrice() {
        return 5;
    }
}
