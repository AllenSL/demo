package com.example.demo.leetcode;

import java.util.HashMap;

/**
 * @author ansonglin
 * @className Test
 * @description TODO
 * @date 2020/1/8 14:28
 * @cersion 1.0
 **/
public class Test {


    public static int[] twoSum(int[] nums,int target){
       int[] newnums =new int[2];
        for(int i = 0;i < nums.length;i ++){
                for(int j = i+1;j <nums.length;j++){
                    if(nums[i] + nums[j] == target ){
                        newnums[0] = i;
                        newnums[1] = j;
                        break;
                    }
                }
        }
        return newnums;
    }

    public static int[] twoSum2(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] newnums =new int[2];
        for(int i = 0;i < nums.length;i ++){
            int dif = target - nums[i];
            if(map.get(dif) != null){
                newnums[0] = i;
                newnums[1] = map.get(dif);
                break;
            }
            map.put(nums[i],i);
        }
        return newnums;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};

        int[] ints = twoSum(nums, 9);
        System.out.println(ints[0] +" || " + ints[1]);
    }
}
   