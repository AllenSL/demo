package com.example.demo.pattern.builder;

public class HouseDirector {
    HouseBuilder houseBuilder = null;

    public HouseDirector(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    //如何建造房子的流程，交给指挥者
    public House constructHourse(){
        houseBuilder.buildBasic();
        houseBuilder.builderWalls();
        houseBuilder.roofed();
        return houseBuilder.build();
    }
}
