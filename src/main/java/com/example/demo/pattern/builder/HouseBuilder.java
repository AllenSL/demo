package com.example.demo.pattern.builder;

//抽象的构建者
public abstract class HouseBuilder {

    protected House house = new House();

    public abstract void buildBasic();

    public abstract void builderWalls();

    public abstract void roofed();

    House build() {
        System.out.println("完成盖房子");
        return house;
    }
}
