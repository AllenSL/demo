package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className 有序数组求和
 * @description TODO
 * @date 2021/3/1 3:53 下午
 * @cersion 1.0
 **/
public class 有序数组求和 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 3, 2, 1};
        int[] arr2 = new int[]{5, 2, 1};
        int[] ints = addSum(arr1, arr2);
        System.out.println(ints);

    }

    /**
     * 求和  思路: 归并排序
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static int[] addSum(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int[] temp = new int[arr1Length + arr2Length];
        while (arr1Length > 0 && arr2Length > 0) {
            if (arr1[i] > arr2[j]) {
                temp[k] = arr1[i];
                arr1Length--;
                i++;
            } else {
                temp[k] = arr2[j];
                arr2Length--;
                j++;
            }
            k++;
        }

        if (arr1Length > 0) {
            while (arr1Length != 0) {
                temp[k] = arr1[arr1.length - arr1Length];
                k++;
                arr1Length--;
            }
        }

        if (arr2Length > 0) {
            while (arr2Length == 0) {
                temp[k] = arr2[arr2.length - arr2Length];
                k++;
                arr2Length--;
            }
        }
        return temp;
    }
}
   