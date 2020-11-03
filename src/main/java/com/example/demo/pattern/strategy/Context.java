package com.example.demo.pattern.strategy;

/**
 * @author ansonglin
 * @className Context
 * @description TODO
 * @date 2019/9/3 11:39
 * @cersion 1.0
 **/
public class Context {

    private SOperation sOperation;

    public void setContext(SOperation sOperation){
        this.sOperation = sOperation;
    }

    public int calculate(int a,int b){
       return sOperation.apply(a,b);
    }
}
   