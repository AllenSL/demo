package com.example.hutool;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *@className ThreadPoolExecutorBuilder
 *@description hutool使用构建者模式创建线程池测试类
 *@author ansonglin
 *@date 2021/2/19 8:51 上午
 *@cersion 1.0
 **/
public class ThreadPoolExecutorBuilder {


    public ExecutorService buildTaskPool(){
      return  ExecutorBuilder.create()
                .setCorePoolSize(2)
                .setMaxPoolSize(5 << 1)
                .setWorkQueue(new LinkedBlockingDeque<>(300))
                .setKeepAliveTime(30, TimeUnit.SECONDS)
                .setThreadFactory(ThreadFactoryBuilder.create().setNamePrefix("TEST").build())
                .setHandler(new ThreadPoolExecutor.AbortPolicy())
                .build();
    }
}
   