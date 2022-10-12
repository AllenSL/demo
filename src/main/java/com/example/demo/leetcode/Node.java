package com.example.demo.leetcode;

public class Node {

    public String val;
    public int intVal;

    public String key;

    public Node next;

    public Node pre;

    public Node(String key,String val) {
        this.key = key;
        this.val = val;
    }

    public Node(int intVal) {
        this.intVal = intVal;
    }
    public Node() {
    }

    public static void main(String[] args) {

        int a = 0;

        while (true){
            System.out.println("pre"+a);
            a = 1;
            System.out.println("after"+a);
        }

    }
}
