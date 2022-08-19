package com.example.demo.leetcode;

import java.io.File;

public class 递归 {

    public static void main(String[] args) {
//      printAllFile(new File("D:\\projects\\app-web"));
        recursion_display(23);
    }


    /*
     关于 递归中 递进和回归的理解*/
    public static void recursion_display(int n) {
        int temp=n;//保证前后打印的值一样
        System.out.println("递进:" + temp);
        if (n > 0) {
            recursion_display(--n);
        }
        System.out.println("回归:" + temp);
    }


   static void printAllFile(File file){
        File[] files = file.listFiles();

        int num = 1;
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            if(file1.isDirectory()){
                System.out.println("递归次数:"+ (num++));
                printAllFile(files[i]);
            }else {
                System.out.println("file name"+ file1.getName());
            }
        }

    }
}
