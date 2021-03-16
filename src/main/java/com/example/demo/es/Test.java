package com.example.demo.es;

import sun.misc.Unsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ansonglin
 * @className Test
 * @description TODO
 * @date 2021/2/4 8:50 下午
 * @cersion 1.0
 **/
public class Test {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println("www");
            Unsafe.getUnsafe().allocateMemory(10000000000L);
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

}
   