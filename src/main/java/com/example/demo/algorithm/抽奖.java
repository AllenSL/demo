package com.example.demo.algorithm;

import java.util.Random;
import java.util.Scanner;

/**
 需求：一个大V直播抽奖，奖品是现金红包，分别有{2, 588 , 888, 1000, 10000}五个奖金。
 请使用代码模拟抽奖，打印出每个奖项，奖项的出现顺序要随机且不重复。打印效果如下：（随机顺序，不一定是下面的顺序）
 */
public class 抽奖 {

    public static void main(String[] args) {
        //奖池集合
        int[] moneyAward = new int[]{2, 588 , 888, 1000, 10000};
        //已中奖集合
        int[] usedMoneyAward = new int[moneyAward.length];

        //开始抽奖
        Scanner sc = new Scanner(System.in);
        //获取随机索引
        Random random = new Random();


        for (int i = 0; i < moneyAward.length; i++) {
        // 分别代表抽奖一次。
            System.out.println("您要开始打开红包吗，您可以输入任意内容进行抽奖：");
            sc.next(); // 目的是为了让程序在这里等一下，直到用户按了数据和回车就下来抽奖一次！


            while (true){
                //开始抽奖
                int index = random.nextInt(moneyAward.length);
                int money = moneyAward[index];

                //是否打印中奖日志
                boolean flag = true;

                for (int i1 = 0; i1 < usedMoneyAward.length; i1++) {
                    if(money == usedMoneyAward[i1]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    usedMoneyAward[i] = money;
                    System.out.println("中奖了，金额:["+money+"]");
                    break;
                }
            }
        }
    }
}
