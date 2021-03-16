package com.example.demo.leetcode;

/**
 * @author ansonglin
 * @className RomanToInt
 * @description TODO
 * @date 2020/9/9 16:35
 * @cersion 1.0
 */
public class RomanToInt {

    public static int romanToInt(String s) {
        int preValue = getValue(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int value = getValue(s.charAt(i));
            if (preValue < value) {
                sum -= preValue;
            } else {
                sum += preValue;
            }
            preValue = value;
        }
        sum += preValue;
        return sum;
    }

    public static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
