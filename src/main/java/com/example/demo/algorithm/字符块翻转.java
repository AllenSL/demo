package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className 字符块翻转
 * @description TODO
 * @date 2021/3/8 9:00 下午
 * @cersion 1.0
 **/
public class 字符块翻转 {

    public static void main(String[] args) {
        String str = "absd...dsafs..sd.fdsf...s.f.ra.";
        String reverseStr = reverStrBlock(str);
        System.out.println(reverseStr);
    }

    private static String reverStrBlock(String str) {
        str = new StringBuffer(str).reverse().toString();
        StringBuffer result = new StringBuffer();
        char[] chars = str.toCharArray();
        boolean strFlag = false;
        boolean zeroFlag = false;
        StringBuffer strBuffer = new StringBuffer();
        StringBuffer zerBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                zerBuffer.append(chars[i]);
                if (strFlag) {
                    result.append(strBuffer.reverse());
                }
                zeroFlag = true;
                strBuffer = new StringBuffer();
            } else {
                strBuffer.append(chars[i]);
                if (zeroFlag) {
                    result.append(zerBuffer.reverse());
                }
                strFlag = true;
                zerBuffer = new StringBuffer();
            }
        }
        result.append(strBuffer.reverse()).append(zerBuffer.reverse());
        return result.toString();
    }
}
   