package com.example.demo.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            int m = i + 1;
            int e = nums.length - 1;

            while (m < e) {
                int sum = nums[i] + nums[m] + nums[e];
                if (Math.abs(target - sum) < (Math.abs(target - res))) {
                    res = sum;
                }
                if (sum > target) {
                    e--;
                } else if (sum < target) {
                    m++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
