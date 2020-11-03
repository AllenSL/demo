package com.example.demo.pattern.factory;

/**
 * @author ansonglin
 * @className Subtraction
 * @description TODO
 * @date 2019/9/3 9:26
 * @cersion 1.0
 **/
public class Subtraction implements Operation {
    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}
   