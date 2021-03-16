package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className BinSearch
 * @description 二分查找
 * @date 2019/9/3 14:25
 * @cersion 1.0
 **/
public class BinSearch {

    /**
     *  * 二分查找普通实现。
     *  * @param srcArray 有序数组
     *  * @param key 查找元素
     *  * @return  不存在返回-1
     *  
     */
    public static int binSearch(int srcArray[], int key) {
        int mid;
        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        System.out.println(BinSearch.binSearch(a, 3));
    }
}
   