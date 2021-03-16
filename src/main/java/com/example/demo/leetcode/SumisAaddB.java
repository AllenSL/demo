package com.example.demo.leetcode;

/**
 * @author ansonglin
 * @className SumisAaddB
 * @description 取出两数之和为指定数的值
 * @date 2020/8/28 18:34
 * @cersion 1.0
 */
public class SumisAaddB {

    public static void main(String[] args) {
        int result = 15;
        int[] num = {1, 2, 4, 7, 11, 15};

        int start = 0;
        int end = num.length - 1;

        while (start < end) {
            if (num[start] + num[end] == result) {
                System.out.println(num[start] + " " + num[end]);
                break;
            } else if (num[start] + num[end] < result) {
                start++;
            } else {
                end--;
            }

        }
    }
}
   