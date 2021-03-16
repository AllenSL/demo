package com.example.demo.pattern.strategy;

/**
 * @author ansonglin
 * @className StrategyPatternDemo
 * @description TODO
 * @date 2019/9/3 11:42
 * @cersion 1.0
 **/
public class StrategyPatternDemo {

    public static void main(String[] args) {
        Context context = new Context();
        context.setContext(new AddOperation());
        System.out.println(context.calculate(1, 4));
        context.setContext(new SubtractionOperation());
        System.out.println(context.calculate(3, 2));
    }

}
   