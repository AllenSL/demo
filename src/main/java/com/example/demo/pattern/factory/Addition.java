package com.example.demo.pattern.factory;

/**
 * @author ansonglin
 * @className AddOperation
 * @description 加法
 * @date 2019/9/3 9:24
 * @cersion 1.0
 **/
public class Addition implements Operation{
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}
   