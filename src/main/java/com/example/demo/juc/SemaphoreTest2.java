package com.example.demo.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest2 {

    public static void main(String[] args){
        Runnable rester=new Runnable() {
            //厕所里现在只有五个坑位
            final Semaphore pitSemaphore=new Semaphore(3,true);
            int count=1;
            @Override
            public void run() {
                int time =(int)(Math.random()*10+2);
                int num=count++;
                try{
                    //当前如厕者占用了一个坑
                    pitSemaphore.acquire();
                    System.out.println("第"+num+"个如厕者正在蹲坑，需要时间"+time+"秒;"+pitSemaphore.toString());
                    Thread.sleep(time*1000);

                    //判断厕所外是否有人再等待
                    if(pitSemaphore.hasQueuedThreads()){
                        //打印等待人数
                        System.out.println("厕所外的等待人数"+pitSemaphore.getQueueLength());
                    }
                    if(num==2){
                        System.out.println("查看许可数"+pitSemaphore.drainPermits()+"     "+pitSemaphore.availablePermits());
                        //查看当前阻塞队列是否使用的时公平锁
                        System.out.println("查看信号量是否公平："+pitSemaphore.isFair());
                    }
                    //检查是否能获得许可
                    System.out.println("查看是否可获得许可"+pitSemaphore.tryAcquire());
                    System.out.println("查看是否可获得许可"+pitSemaphore.tryAcquire(2,100, TimeUnit.MICROSECONDS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    pitSemaphore.release();
                    System.out.println("第"+num+"个如厕者出去了");
                }
            }
        };
        for (int i=1;i<10;i++){
            new Thread(rester).start();
        }
    }
}
