package com.example.demo.leetcode;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = {3, 4, 1, 2};
        selectionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums){
        for (int i = nums.length - 1; i >= 0; i--) {
            for(int j = i+1;j<nums.length - 1;j ++){
                if(nums[i] >nums[j]){
                    swap(nums,i,j);
                }
            }

        }

    }

    private void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
