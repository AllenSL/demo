package com.example.demo.pattern.decorator.test1;

public class EggDecorator extends BattercakeDecorator{

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+鸡蛋";
    }

    @Override
    protected Integer getPrice() {
        return super.getPrice()+1;
    }
}
