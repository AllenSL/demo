package com.example.demo.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedEnvelope {


    public static void main(String[] args) {
        List<Integer> amountList=divideRedPackage(100,10);
        for(Integer amount:amountList)
        {
            System.out.println("抢到金额："+new BigDecimal(amount));
        }
    }

    /*
     * @param totalAmount 总金额（以分为单位）
     * @param totalPeopleNum 总人数
     * */
    public static List<Integer> divideRedPackage(Integer totalAmount,Integer totalPeopleNum)
    {
        List<Integer> amountList=new ArrayList<Integer>();
        Integer restAmount=totalAmount;
        Integer restPeopleNum=totalPeopleNum;
        Random random=new Random();
        for (int i=0;i<totalPeopleNum-1;i++)
        {
            int amount=random.nextInt(restAmount/restPeopleNum*2-1)+1;
            restAmount-=amount;
            restPeopleNum--;
            amountList.add(amount) ;
        }
        amountList.add(restAmount);

        return  amountList;
    }


}
