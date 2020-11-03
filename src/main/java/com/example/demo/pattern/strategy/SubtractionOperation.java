package com.example.demo.pattern.strategy;

/**
 * @author ansonglin
 * @className SubtractionOperation
 * @description TODO
 * @date 2019/9/3 11:38
 * @cersion 1.0
 **/
public class SubtractionOperation implements SOperation {
    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}
   