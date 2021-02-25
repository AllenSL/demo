package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className SleepSort
 * @description 睡眠排序
 * @date 2020/12/27 4:38 下午
 * @cersion 1.0
 **/
public class SleepSort implements Runnable {

    private int num;

    public SleepSort(int num) {
        this.num = num;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(num );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(num);
    }

    public static void main(String[] args) {

    }
}
   