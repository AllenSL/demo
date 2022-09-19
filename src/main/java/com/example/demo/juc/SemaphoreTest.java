package com.example.demo.juc;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreTest  {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            final int num = i;
            new Thread(()->{
                try {
                    Random random = new Random();
                    int time = random.nextInt(10);
                    semaphore.acquire();
                    System.out.println(">>>>第" + num + "顾客进店了,购物时间:" + time + "秒,semaphore:" + semaphore.toString());
                    Thread.sleep(time * 1000);
                    if (semaphore.hasQueuedThreads()) {
                        int b = semaphore.getQueueLength();
                        System.out.println("进店排队人数:" + b);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("<<<<第" + num + "顾客消费完，出店了");
                }
            }).start();
        }


    }

}
