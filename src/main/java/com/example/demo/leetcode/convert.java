package com.example.demo.leetcode;

/**
 * leetcode 第6题
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class convert {


    public static void main(String[] args) {
//        process("LEETCODEISHIRING",4);
//        System.out.println(convert("LEETCODEISHIHRING", 4));
        System.out.println(3%3);
    }



   static String process(String str, Integer num){
        if(str == null || str.length() < 1){
            return str;
        }

        for(int i = 0; i < str.length(); i++){
            int ans = i / (num - 1);
            if(ans % 2 == 0){
                System.out.println("|||竖列:"+str.charAt(i));
            }else {
                System.out.println("---横列:"+str.charAt(i));
            }
            int remain = i % (num - 1);
        }
        return null;
    }



        public static String convert(String s, int numRows) {
            int len = s.length();
            if (len == 0 || numRows < 1) {
                return "";
            }
            StringBuilder[] res = new StringBuilder[numRows];
            for (int i = 0; i < numRows; ++i) {
                res[i] = new StringBuilder();
            }
            int ans;
            int remain;
            for (int i = 0; i < len; ++i) {
                ans = i / (numRows-1);
                remain = i % (numRows-1);
                if (ans % 2 == 0) {
                    res[remain].append(s.charAt(i));
                } else {
                    res[numRows-remain-1].append(s.charAt(i));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numRows; ++i) {
                stringBuilder.append(res[i].toString());
            }
            return stringBuilder.toString();
        }

}
