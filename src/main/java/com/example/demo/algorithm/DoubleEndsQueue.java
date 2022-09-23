package com.example.demo.algorithm;

import java.util.Stack;

/**
 * 双向链表实现队列,队列实现栈
 */
public class DoubleEndsQueue<T> {

    private ListNode tail;
    private ListNode head;

    void addFromHead(int value) {
        ListNode cur = new ListNode(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.pre = cur;
            head = cur;
        }
    }

    void addFromBottom(int value) {
        ListNode cur = new ListNode(value);
        if (head == null) {
            tail = cur;
            head = cur;
        } else {
            tail.next = cur;
            cur.pre = tail;
            tail = cur;
        }
    }

    int popFromHead() {
        if (head == null) {
            return 0;
        }
        ListNode cur = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            cur.next = null;
            head.pre = null;
        }
        return cur.val;
    }

    int popFromTail() {
        if (head == null) {
            return 0;
        }
        ListNode cur = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
            cur.pre = null;
        }
        return cur.val;
    }


    public class MyStack {
        DoubleEndsQueue<T> doubleEndsQueue;

        MyStack() {
            doubleEndsQueue = new DoubleEndsQueue<>();
        }

        void add(int value) {
            doubleEndsQueue.addFromHead(value);
        }

        int pop() {
            return doubleEndsQueue.popFromHead();
        }
    }


    public class MyStack2 {
        //全部数据集合(空+非空)
        int[] data = new int[7];
        int size = 0;
        int pushIndex;
        int popIndex;

        void push(int value) {
            if (size == 7) {
                return;
            }
            data[pushIndex] = value;
            size++;
            pushIndex = nextIndex(pushIndex);
        }

        int pop() {
            if (size == 0) {
                return 0;
            }
            size--;
            int result = data[popIndex];
            popIndex = nextIndex(popIndex);
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int nextIndex(int i) {
            return i < 6 ? (i + 1) : 0;
        }
    }


    public static class MyStack3 {
        Stack<Integer> normalStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        void push(int num) {
            if (minStack.isEmpty() || num < this.getMin()) {
                minStack.push(num);
            } else {
                minStack.push(this.getMin());
            }
            normalStack.push(num);
        }

        int pop() {
            minStack.pop();
            return normalStack.pop();
        }

        int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("当前栈为空");
            }
            return minStack.peek();
        }
    }



    public static class MyQueue{
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();

        void push(int num){
            popToPush();
            if(popStack.isEmpty()){
                 pushStack.push(num);
             }
        }

        int pop(){
            pushToPop();
            return popStack.pop();
        }

        void pushToPop(){
            if(popStack.isEmpty()){
                while (!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
        }

        void popToPush(){
            if(pushStack.isEmpty()){
                while (!popStack.isEmpty()){
                    pushStack.push(popStack.pop());
                }
            }
        }

        boolean isEmpty(){
            return pushStack.isEmpty() && popStack.isEmpty();
        }

    }

    public static void main(String[] args) {
//        MyStack3 myStack3 = new MyStack3();
//        myStack3.push(4);
//        myStack3.push(2);
//        myStack3.push(5);
//        System.out.println(myStack3.getMin());
//        myStack3.push(1);
//        System.out.println(myStack3.getMin());

        MyQueue myQueue = new MyQueue();
        myQueue.push(3);
        myQueue.push(2);
        myQueue.push(4);
        myQueue.push(1);
        System.out.println(myQueue.pop());
        myQueue.push(7);
        System.out.println(myQueue.pop());
        while (!myQueue.isEmpty()){
            System.out.println(myQueue.pop());
        }


        int a = 0;
        int[] arr = new int[]{3,2};

        while (a < 5){
            System.out.println(arr[a++]);
        }



    }
}