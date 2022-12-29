package com.example.demo.pattern.decorator.test1;

public class SausageDecorator extends BattercakeDecorator{

    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() +"+烤肠";
    }

    @Override
    protected Integer getPrice() {
        return super.getPrice()+ 3;
    }
}
