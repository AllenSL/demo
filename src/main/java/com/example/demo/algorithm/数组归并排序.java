package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className 数组归并排序
 * @description TODO
 * @date 2021/3/9 9:19 下午
 * @cersion 1.0
 **/
public class 数组归并排序 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,5,6,8};

        int[] arr2 = new int[]{3,4,7};
        int[] ints = mergeSort(arr1, arr2);
        System.out.println(ints);
    }

    private static int[] mergeSort(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length+arr2.length];
        int k = 0;
        int j = 0;
        int i = 0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] > arr2[j]){
                result[k] = arr2[j];
                j++;
            }else {
                result[k] = arr1[i];
                i++;
            }
            k++;
        }
        if(i < arr1.length){
            for (int l = i;l<arr1.length;l++){
                result[k++] = arr1[l];
            };
        }
        if(j < arr2.length){
            for (int l = j;l<arr2.length;l++){
                result[k++] = arr2[l];
            }
        }
        return result;
    }
}
   