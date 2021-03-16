package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className 快速排序
 * @description TODO
 * @date 2021/3/6 9:57 下午
 * @cersion 1.0
 **/
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 2, 6, 8, 1, 9, 5,99,5,2};
        quitSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void quitSort(int[] arr, int left, int right) {
     if(left < right){
         int mid = sort(arr,left,right);
         quitSort(arr,left,mid-1);
         quitSort(arr,mid+1,right);
     }
    }

    private static int sort(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j){
            while (arr[j] >= pivot && i < j){
                j --;
            }
            if(i < j){
                arr[i] = arr[j];
                i++;
            }

            while (arr[i] < pivot && i < j) {
                i ++;
            }
            if(i < j){
             arr[j] = arr[i];
             j--;
            }
        }
        arr[i] = pivot;
        return i;
    }

    private static void mySwap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    ;

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}
   