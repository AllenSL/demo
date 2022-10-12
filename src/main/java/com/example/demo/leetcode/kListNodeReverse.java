package com.example.demo.leetcode;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 每k个节点为一组链表反转，尾部不够k个则不反转
 */
public class kListNodeReverse {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> System.out.println("无返回结果异步任务");
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(runnable);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回值的异步任务");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello World";
        });
        String result = future.get();
        System.out.println(result);
        Void unused = voidCompletableFuture.get();
        try {
            ReentrantLock lock = new ReentrantLock();
            lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }

    static Node process(Node head, Integer k) {
        Node start = head;
        Node end = getLastNode(start, k);
        //不够k个节点则直接返回
        if (end == null) {
            return head;
        }
        //上一组的尾结点是下一组的起点
        head = end;
        reverse(start, end);
        Node lastEnd = start;
        //
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getLastNode(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }


    /**
     * 反转链表到指定节点停止
     *
     * @param start
     * @param end
     */
    static void reverse(Node start, Node end) {
        end = end.next;
        Node pre = null;
        Node cur = start;
        Node next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    /**
     * 获取链表指定长度k，最后一个节点
     *
     * @param start
     * @param k
     * @return
     */
    static Node getLastNode(Node start, Integer k) {
        while (--k > 0 && start.next != null) {
            start = start.next;
        }
        return start;
    }


}
