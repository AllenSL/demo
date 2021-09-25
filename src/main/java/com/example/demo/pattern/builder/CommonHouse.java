package com.example.demo.pattern.builder;

public class CommonHouse extends HouseBuilder{


    public CommonHouse(House house){
        this.house = house;
    }

    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基"+house.getBaise());
    }

    @Override
    public void builderWalls() {
        System.out.println("普通房子砌墙"+house.getWall());
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶"+house.getRoofed());
    }
}
