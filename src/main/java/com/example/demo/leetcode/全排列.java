package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    private static List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        p(nums, 0, nums.length - 1);
        return res;
    }

    public void p(int[] nums, int p, int q) {
        if (p == q) {
            List<Integer> l = new ArrayList<>();
            for (int s : nums) {
                l.add(s);
            }
            res.add(l);
        } else {
            for (int i = p; i <= q; i++) {
                swap(nums, p, i);
                p(nums, p + 1, q);
                swap(nums, p, i);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
