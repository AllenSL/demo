package com.example.demo.leetcode;

import java.util.Stack;

/**
 * @author ansonglin
 * @className StackQueue
 * @description TODO
 * @date 2021/2/27 1:14 下午
 * @cersion 1.0
 **/
public class StackQueue {


    Stack<Integer> inStack = new Stack();
    Stack<Integer> outStack = new Stack<>();

    public void push(Integer num) {

        while (!outStack.empty()) {
            inStack.push(outStack.pop());
        }
        inStack.push(num);
        System.out.println("push :" + num);
    }

    public Integer pop() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        Integer result = outStack.pop();
        System.out.println("result" + result);
        return result;
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(3);
        stackQueue.push(2);
        stackQueue.push(1);
        stackQueue.pop();
        stackQueue.pop();
        stackQueue.pop();
        stackQueue.push(4);
        stackQueue.pop();

    }
}
   