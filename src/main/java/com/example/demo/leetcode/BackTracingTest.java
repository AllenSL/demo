package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法练习
 */
public class BackTracingTest {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    /**
     * 括号生成器leetcode22
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且
     * 有效的 括号组合。
     */
    public static List<String> generateParenthesis(int n) {
        String singleStr = "()";
        List<String> res = new ArrayList<>();
        if (n == 1) {
            res.add(singleStr);
            return res;
        }
        char[] str = new char[2 * n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                str[i] = '(';
            } else {
                str[i] = ')';
            }
        }

        generateParenthesis(n, res, str, new char[2]);
        return res;
    }

    /**
     * 使用回溯算法实现
     * （ ）（ ）（ ）
     * @param n
     * @param res
     * @param str
     */
    static void generateParenthesis(int n, List<String> res, char[] str, char[] okStr) {
        if (okStr.length == 2 * n) {
            if (valid(okStr)) {
                res.add(new String(okStr));
            }
            return;
        }

        int length = str.length;
        for (int i = 0; i < length; i++) {
            okStr[i] = str[i];
            generateParenthesis(n, res, str, okStr);
        }
    }

    /**
     * 检查生成的字符串是否合法
     *
     * @return
     */
    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

}
