package com.example.demo.leetcode;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = {3, 4, 1, 2};
        selectionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j= i+1;j< arr.length ;j ++){
              minIndex = arr[minIndex] > arr[j]?j:minIndex;
            }
            swap(arr,i,minIndex);
        }

    }

    private void swap(int[] arr, int i, int minIndex) {
         int temp = arr[i];
         arr[i] = arr[minIndex];
         arr[minIndex] = temp;
    }
}
