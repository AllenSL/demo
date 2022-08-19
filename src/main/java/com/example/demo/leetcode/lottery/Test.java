package com.example.demo.leetcode.lottery;

import java.util.*;

public class Test {

    static final int TIME = 10000;

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(9d);
        list.add(5d);
        list.add(2d);
        list.add(1d);
        list.add(6d);
        hah util = new hah(list);
        Map<Integer,Integer> map = new HashMap<>();
        double maxEle = util.getMaxEle();
        for (int i = 0; i < TIME; i++) {
            int i1 = util.randomColunmIndex();
            if(map.containsKey(i1)){
               map.put(i1,map.get(i1)+1);
            }else {
                map.put(i1,1);
            }
        }

        for (int i = 0; i < list.size(); i++) {
             double probability = list.get(i)/maxEle;
             list.set(i,probability);
        }

        itertorMap(map,list);
    }

    private static void itertorMap(Map<Integer, Integer> map, List<Double> list) {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer, Integer> m:entries){
            Integer index = m.getKey();
            Integer time = m.getValue();
            Result result = new Result(index,TIME,time,list.get(index),(double)time/TIME);
            System.out.println(result);
        }
    }
}
