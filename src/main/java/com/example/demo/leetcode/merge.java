package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class merge {

    public static int[][] process(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println();

        return null;
    }

    public static void main(String[] args) {
        int [][] arr=new int[3][];
        int[] a1 = new int[2];
        a1[0] = 2;
        a1[1] = 4;

        int[] a2 = new int[2];
        a2[0] = 1;
        a2[1] = 5;

        int[] a3 = new int[2];
        a3[0] = 4;
        a3[1] = 6;

        arr[0] = a1;
        arr[1] = a2;
        arr[2] = a3;
        process(arr);
    }
}
