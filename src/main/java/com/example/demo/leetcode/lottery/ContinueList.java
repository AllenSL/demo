package com.example.demo.leetcode.lottery;

public class ContinueList {

    private double minEle;

    private double maxEle;

    public ContinueList(double minEle,double maxEle){
        if(maxEle < minEle){
            throw new RuntimeException("。。。");
        }
         this.minEle = minEle;
         this.maxEle = maxEle;
    }


    public boolean isContainKey(double key){
        return key < maxEle && key > minEle;
    }

}
