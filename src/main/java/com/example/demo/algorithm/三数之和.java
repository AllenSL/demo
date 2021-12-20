package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
      if(nums.length == 0){
          return new ArrayList<>();
      }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > 0){
                return result;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while ( L < R ){
                int sum = nums[L] + nums[i] + nums[R];
                if(sum == 0){
                    result.add(Arrays.asList(nums[L],nums[i],nums[R]));
                    while (L < R && nums[L+1] == nums[L]){
                         ++L;
                    }
                    while (L < R && nums[R-1] == nums[R]){
                        --R;
                    }
                    ++L;
                    --R;
                }else if(sum > 0){
                    --R;
                }else {
                    ++L;
                }
            }
        }
        return result;
    }

}
