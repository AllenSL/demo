package com.example.demo.pattern.decorator.test1;

public class BattercakeDecoratorTest {

    public static void main(String[] args) {
        Battercake battercake = new BaseBattercake();
        battercake = new EggDecorator(battercake);
        battercake = new SausageDecorator(battercake);

        System.out.println("买了一个："+battercake.getMsg()+" 价格为: "+battercake.getPrice());

    }

}
