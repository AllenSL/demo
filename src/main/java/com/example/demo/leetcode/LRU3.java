package com.example.demo.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU3 {

    /**
     * 利用linkHashMap添加元素会直接添加到末尾的特性
     */
    LinkedHashMap<String, String> map;
    /**
     * 缓存淘汰阈值
     */
    int limit;
    /**
     * 当前缓存数据
     */
    int size;

    LRU3(int limit) {
        this.limit = limit;
        map = new LinkedHashMap<>();
    }

    public void put(String key, String val) {
        String cacheVal = map.get(key);
        if (cacheVal == null && size >= limit) {
            //移除末尾数据
            removeTopEle();
            size--;
        } else {
            //利用linkHashMap自带特性直接移除即可
            map.remove(key);
        }
        //添加到队列尾部
        map.put(key, val);
        size++;
    }

    private void removeTopEle() {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        Map.Entry<String, String> next = iterator.next();
        map.remove(next.getKey());
    }


    public String get(String key) {
        String val = map.get(key);
        if (val == null) {
            return null;
        }
        map.remove(key);
        map.put(key, val);
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LRU3 lru3 = new LRU3(1);
        lru3.put("key1", "key1");
        lru3.put("key2", "key2");
        System.out.println(lru3.get("key1"));
        System.out.println(lru3.get("key2"));
        System.out.println(lru3.size());
        System.out.println(lru3.isEmpty());


        System.out.println(12%10);
        System.out.println(12/10);

        Node node = new Node(2);
        Node node1 = new Node(3);
        node.next = node1;

        Node n1 = node;
        n1.next = new Node(4);
        n1.next.next = new Node(5);
        while (n1 != null){
            n1 = n1.next;
        }
        System.out.println(node);

    }
}
