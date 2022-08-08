package com.example.demo.leetcode.lottery;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotteryUtil {

    /**
     * 概率集合
     */
   private List<ContinueList> lotteryList;

    /**
     * 初始值0.0
     */
   private double maxEle;

    /**
     * 构造抽奖集合
     * @param list 奖品概率
     */
   public LotteryUtil(List<Double> list){
       lotteryList = new ArrayList<>();
       if(CollectionUtils.isEmpty(list)){
           throw new RuntimeException("抽奖集合不能为空");
       }

       double minEle = 0d;
       ContinueList continueList = null;
       for (Double d : list) {
           minEle = maxEle;
           maxEle = maxEle+d;
           continueList = new ContinueList(minEle,maxEle);
           lotteryList.add(continueList);
       }
   }

    /**
     * 抽奖操作
     * 返回:奖品的概率list集合中的下标
     * @return
     */
   public int randomColunmIndex(){
       int index = -1;

       Random random = new Random();
       double d = random.nextDouble() * maxEle;
       if(d == 0d){
           d = random.nextDouble()*maxEle;
       }
       for (int i = 0; i < lotteryList.size(); i++) {
           if(lotteryList.get(i).isContainKey(d)){
               index = i;
               break;
           }
       }
       if(index == -1){
           throw new RuntimeException("概率集合设置不合理");
       }
       return index;
   }

    public List<ContinueList> getLotteryList() {
        return lotteryList;
    }

    public void setLotteryList(List<ContinueList> lotteryList) {
        this.lotteryList = lotteryList;
    }

    public double getMaxEle() {
        return maxEle;
    }

    public void setMaxEle(double maxEle) {
        this.maxEle = maxEle;
    }

    public static void main(String[] args) {
    }

}
