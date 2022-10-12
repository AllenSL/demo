package com.example.demo.leetcode;

import java.util.HashMap;

public class LRU2 {

    HashMap<String, Node> cache = new HashMap<>();
    Node head;
    Node tail;
    int size = 0;
    int limit;

    LRU2(int limit) {
        this.limit = limit;
        head = new Node();
        tail = new Node();
        //首尾相连初始化双向链表
        head.next = tail;
        tail.pre = head;
    }

    public void put(String key, String val) {
        Node cacheNode = cache.get(key);
        if (null == cacheNode) {
            if (size >= limit) {
                //超限，移除尾部节点
                Node delNode = removeNodeTail();
                cache.remove(delNode.key);
                size--;
            }
            Node newNode = new Node(key, val);
            //添加新节点到头部
            addNodeToHead(newNode);
            //此处注意，一定要将节点addNodeToHead之后才put到map中，这样放进去的节点是有前后指针引用的，这样后面移除节点时才不会报错
            cache.put(key, newNode);
            size++;
        } else {
            moveToHead(cacheNode);
        }
    }

    private Node removeNodeTail() {
        Node pre = tail.pre;
        removeNode(pre);
        return pre;
    }

    public String get(String key) {
        Node node = cache.get(key);
        if (null == node) {
            return null;
        }
        moveToHead(node);
        return node.val;
    }


    private void moveToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addNodeToHead(Node node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    public static void main(String[] args) {
        LRU2 lru = new LRU2(1);
        lru.put("age", "age");
        lru.put("name", "name");
        System.out.println(lru.get("age"));
        System.out.println(lru.get("name"));
    }
}
