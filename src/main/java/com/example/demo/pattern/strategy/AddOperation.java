package com.example.demo.pattern.strategy;

/**
 * @author ansonglin
 * @className AddOperation
 * @description TODO
 * @date 2019/9/3 11:37
 * @cersion 1.0
 **/
public class AddOperation implements SOperation {
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}
   