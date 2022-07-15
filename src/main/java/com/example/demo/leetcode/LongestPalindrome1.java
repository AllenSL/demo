package com.example.demo.leetcode;

/**
 * 计算最长回文字符串
 */
public class LongestPalindrome1 {

    /**
     * 暴力破解
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {// 最后一个字符没必要枚举了
            for (int j = i + 1; j < len; j++) {
                // 最长回文串：长度>之前的max，且，是回文串
                if (j - i + 1 > maxLen && isPalindrome(cs, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static boolean isPalindrome(char[] cs, int i, int j) {
        while (i < j) {
            if (cs[i] != cs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "ac";
        System.out.println(longestPalindrome(str));

        System.out.println("as");
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left < right){
            int area = Math.min(height[right] , height[left]) * (right - left);
            maxArea = Math.max(maxArea,area);
            if(height[right] > height[left]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
