package com.example.demo.pattern.decorator.test1;

public abstract class BattercakeDecorator extends Battercake{

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake){
        this.battercake = battercake;
    }

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected Integer getPrice() {
        return this.battercake.getPrice();
    }
}
