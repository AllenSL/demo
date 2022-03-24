package com.example.demo.leetcode;

import java.util.HashSet;

/**
 * @author ansonglin
 * @className LengthOfLongestSubstring
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>示例 1:
 * <p>输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>来源：力扣（LeetCode）
 * @date 2020/7/29 11:48
 * @cersion 1.0
 */
public class LengthOfLongestSubstring {

    private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int length = s.length();
        int rk= -1,result = 0;
        for (int i = 0; i < length; i++) {
            if(i > 0){
                set.remove(s.charAt(i-1));
            }

            while (rk+1<length && !set.contains(s.charAt(rk+1)) ){
                set.add(s.charAt(rk+1));
                ++rk;
            }

            result = Math.max(result,rk-i+1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcaef"));
    }
}
   