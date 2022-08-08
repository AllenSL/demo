package com.example.demo.pattern.builder;

public class HighBuilding extends HouseBuilder{

    public HighBuilding(House house){
        this.house = house;
    }

    @Override
    public void buildBasic() {
        System.out.println("高楼房子打地基");
    }

    @Override
    public void builderWalls() {
        System.out.println("高楼房子砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("高楼房子封顶");
    }
}
