package com.example.demo.algorithm;

import java.util.Stack;

/**
 * @author ansonglin
 * @className A
 * @description 使用栈构建队列：一个是入队 一个是出队 入队要保证将出队里面的数据取出来放到入队里面保证整体顺序
 * @date 2021/2/26 2:52 下午
 * @cersion 1.0
 **/

class StackQueue {

    //入队的栈
    Stack<Integer> stack1 = new Stack<>();

    //出队的栈
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队
     */
    public void push(Integer num) {
        //入队保证出栈为空
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        System.out.println("入队元素：" + num);
        stack1.push(num);
    }

    /**
     * 出队
     *
     * @return
     */
    public Integer pop() {
        //保证进栈为空
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        Integer pop = stack2.pop();
        System.out.println("出队元素:" + pop);
        return pop;
    }

    public static void main(String[] arg) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        stackQueue.pop();
        stackQueue.pop();
        stackQueue.pop();
        stackQueue.push(9);
        stackQueue.pop();
        stackQueue.pop();

    }
}

   