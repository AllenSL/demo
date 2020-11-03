package com.example.demo.test;

public class Test1 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i <= 100; i++) {
            int x = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    x++;
                }
            }
            if (x == 0) {
                sum += i;
            }
        }
        System.out.print(sum);
    }


}
