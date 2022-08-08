package com.example.demo.pattern.builder;

public class Client {

    public static void main(String[] args) {
        HouseDirector houseDirector =
                new HouseDirector(
                        new CommonHouse(
                                new House("1","2","23")));
        House house = houseDirector.constructHourse();
        System.out.println(house);
    }
}
