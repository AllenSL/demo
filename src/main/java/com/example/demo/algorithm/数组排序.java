package com.example.demo.algorithm;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ansonglin
 * @className 数组排序
 * @description TODO
 * @date 2021/2/27 5:08 下午
 * @cersion 1.0
 **/
public class 数组排序 {

    public static int[] MySort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("", 1);
        int[] a = new int[]{5, 1, 6, 2, 5};
        int[] ints = MySort(a);
        System.out.println();
    }
}
   