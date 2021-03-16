package com.example.demo.leetcode;

/**
 * @author ansonglin
 * @className Reverse
 * @description TODO
 * @date 2020/7/29 17:07
 * @cersion 1.0
 **/
public class Reverse {

    public static int reverse(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(Long.valueOf(reverse));
    }
}
   