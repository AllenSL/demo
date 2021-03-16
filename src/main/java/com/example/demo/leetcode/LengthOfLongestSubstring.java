package com.example.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

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
        Set<Character> set = new HashSet<>();
        int start = 0;
        int max = 0;
        int index = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (set.contains(ch)) {
                while (set.contains(ch)) {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            max = Math.max(max, index - start + 1);
            set.add(ch);
            index++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcaef"));
    }
}
   