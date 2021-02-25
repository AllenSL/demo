package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className MergeSort
 * @description 归并排序
 * @date 2020/10/14 10:57
 * @cersion 1.0
 **/
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{11, 44, 23, 67, 88, 65, 34, 48, 9, 12};
        int[] temp = new int[arr.length];
        MergeSort(arr, 0, arr.length - 1, temp);
        for (int j = 0; j < arr.length; j++) System.out.println(arr[j]);
    }

    public static void MergeSort(int[] arr, int leftPtr, int high, int[] temp) {
        int mid = leftPtr + (high - leftPtr) / 2;
        if (leftPtr == high) {
            return;
        }
        MergeSort(arr, leftPtr, mid, temp);
        MergeSort(arr, mid + 1, high, temp);
        merge(arr, leftPtr, high, temp, mid);


    }


    public static void merge(int[] arr, int low, int high, int[] temp, int mid) {
        int i = 0;
        int j = low, k = mid + 1;
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                temp[i++] = arr[j++];
            } else {
                temp[i++] = arr[k++];
            }
        }

        while (j <= mid) {
            temp[i++] = arr[j++];
        }

        while (k <= high) {
            temp[i++] = arr[k++];
        }

        for (int t = 0; t < i; t++) {
            arr[low + t] = temp[t];
        }
    }
}
