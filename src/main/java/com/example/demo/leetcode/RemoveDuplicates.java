package com.example.demo.leetcode;

import java.util.Arrays;

public class RemoveDuplicates {



//    public int removeDuplicates(int[] nums) {
//        Map map =new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],nums[i]);
//        }
//    }

//    public int removeDuplicates(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int i = 0, j = 0;
//        while (j < nums.length) {
//            if (nums[i] != nums[j]) {
//                nums [++i] = nums[j];
//            }
//            j++;
//        }
//        return ++i;
//    }



    public static int removeDuplicates(int[] nums){
        if(nums.length == 0){
            return 0;
        };
        int i = 0,j=0;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }















    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0,num = 0,right=people.length-1;
        while (left<=right){
            if(people[left]+people[right] <=limit){
              left++;
            }
            right--;
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2};
        System.out.println(removeDuplicates(a));

        int i = 0;
        System.out.println();
    }
}
