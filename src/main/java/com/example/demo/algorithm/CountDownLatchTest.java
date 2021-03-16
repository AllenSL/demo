package com.example.demo.algorithm;

import java.util.concurrent.CountDownLatch;

/**
 * @author ansonglin
 * @className CountDownLatch
 * @description TODO
 * @date 2021/3/3 10:49 上午
 * @cersion 1.0
 **/
public class CountDownLatchTest implements Runnable {

    static int product = 1;
    private static Integer NUM = 10;
    public static CountDownLatch cdl = new CountDownLatch(NUM);

    public static void main(String[] args) {
        for (Integer i = 0; i < NUM; i++) {
            new Thread(new CountDownLatchTest()).start();
            cdl.countDown();
        }
    }


    @Override
    public void run() {
        try {
            cdl.await();
            if (product > 0) {
                Thread.sleep(5);
                product--;
            }
            System.out.println(product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
   