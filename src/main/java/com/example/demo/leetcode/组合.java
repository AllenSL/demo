package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合 {

    LinkedList<Integer> resEnty = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        commbineNum(n,k,1);
        return res;
    }

    private void commbineNum(int n, int k, int startIndex) {
        if(resEnty.size() == k){
            res.add(new ArrayList<>(resEnty));
            return;
        }

        for (int i = startIndex;i <= n-(k - resEnty.size())+1;i++){
            resEnty.add(i);
            commbineNum(n,k,i+1);
            //回溯
            resEnty.removeLast();
        }
    }

    public static void main(String[] args) {
        组合 zh = new 组合();
        System.out.println(zh.combine(2,2));
    }
}










