package com.example.demo.leetcode;

public class SecorndSearch {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low<high){
            int mid = (high-low)/2+low;
            if(nums[mid] > target){
             high = mid+1;
            }else if(nums[mid] < target){
                low = mid -1;
            }else {
                return mid;
            }
        }
        return  -1;
    }
}
