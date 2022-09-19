package com.example.demo.leetcode;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = {3, 4, 1, 2,1,2};
        selectionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
