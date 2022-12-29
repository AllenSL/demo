package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ss {


    static List<List<Integer>> res = new ArrayList();
    static List<Integer> path = new ArrayList();

    public static List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    static void backtrack(int startIndex, int end, int k) {
        if (path.size() == k) {
            List<Integer> temp = new ArrayList();
            for (int j = 0; j < path.size(); j++) {
                temp.add(path.get(j));
            }
            res.add(temp);
            return;
        }

        for (int i = startIndex; i <= end; i++) {
            path.add(i);
            backtrack(i + 1, end, k);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Redisson redisson = new Redisson();
//        RLock lock = redisson.getLock("test");
//        lock.tryLock();
//        lock.lock();


        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
       Long current = System.currentTimeMillis();
       Thread.sleep(4);
        long start = 0L;
        start -= System.currentTimeMillis() - current;
        System.out.println(start);

        System.out.println(combine(1, 1));
    }
}
