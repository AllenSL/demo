package com.example.demo.leetcode;

/**
 * @author ansonglin
 * @className IsPalindrome
 * @description TODO
 * @date 2020/7/31 15:31
 * @cersion 1.0
 **/
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        String s = stringBuilder.toString();
        if(s.equals(stringBuilder.reverse())){
            return true;
        }
        return false;
    }

  public static void main(String[] args) {
      isPalindrome(-123);
  }
}
   