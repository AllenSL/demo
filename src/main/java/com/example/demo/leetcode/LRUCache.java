package com.example.demo.leetcode;

import java.util.HashMap;


public class LRUCache {

    public class ListNode{
        int val;
        int key;
        ListNode pre;
        ListNode next;
        public ListNode( int key,int val){
            this.val = val;
             this.key = key;
        }
        public ListNode( ){
        }
    }

    HashMap<Integer,ListNode> cache = new HashMap<>();
    int capacity;
    int size;
    ListNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        ListNode listNode = cache.get(key);
        if(listNode == null){
            return -1;
        }
        moveToHead(listNode);
        return listNode.val;
    }

    private void moveToHead(ListNode listNode) {
        removeNode(listNode);
        addToHead(listNode);
    }

    private void addToHead(ListNode listNode) {
        listNode.pre = head;
        listNode.next = head.next;
        head.next.pre = listNode;
        head.next = listNode;
    }

    private void removeNode(ListNode listNode) {
        listNode.pre.next = listNode.next;
        listNode.next.pre = listNode.pre;
    }

    public void put(int key, int value) {
        ListNode listNode = cache.get(key);
        if(null == listNode){
            ListNode node = new ListNode(key, value);
            cache.put(key,node);
            addToHead(node);
            ++size;
            if(size > capacity){
                ListNode delNode = removeTail();
                cache.remove(delNode.key);
                --size;
            }
        }else {
            listNode.val = value;
            moveToHead(listNode);
        }
    }

    private ListNode removeTail() {
        ListNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(1,2);
        lruCache.put(2,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

        int mid = (5+8)/2;
        System.out.println(mid);
        int mid1 =5+ (8-5)/2;
        System.out.println(mid1);
        System.out.println(2<<2 | 1);
        System.out.println(6^7);
    }




    ListNode revertListNode(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            //select single node
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
