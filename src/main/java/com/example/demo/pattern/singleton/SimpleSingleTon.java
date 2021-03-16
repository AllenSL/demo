package com.example.demo.pattern.singleton;

public class SimpleSingleTon {

    private SimpleSingleTon() {
    }

    private static SimpleSingleTon singleTon = null;

    public static SimpleSingleTon getInstanc() {
        if (null == singleTon) {
            singleTon = new SimpleSingleTon();
        }
        return singleTon;
    }
}
