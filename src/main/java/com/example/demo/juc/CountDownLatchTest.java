package com.example.demo.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ansonglin
 * @className CutDownLatch
 * @description TODO
 * @date 2020/9/25 18:36
 * @cersion 1.0
 **/
public class CountDownLatchTest implements Runnable {

    CountDownLatch cd;

    private String name;

    CountDownLatchTest(CountDownLatch cd, String name) {
        this.cd = cd;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "ok");
        cd.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch cd = new CountDownLatch(2);
        CountDownLatchTest cdt1 = new CountDownLatchTest(cd, "t1");
        CountDownLatchTest cdt2 = new CountDownLatchTest(cd, "t2");
        executor.execute(cdt1);
        executor.execute(cdt2);
        cd.await();
        System.out.println("main 开始执行");
    }
}
   