package com.example.demo.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("hahah");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("dadada");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("over");

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("test");
        executorService.submit(thread1);
    }
}
