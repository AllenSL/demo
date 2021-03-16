package com.example.demo.pattern.responsibilitychain.demo1;

/**
 * @author ansonglin
 * @className Main
 * @description 责任链设计模式
 * @date 2019/12/2 10:50
 * @cersion 1.0
 **/
public class Main {

    public static void runChain() {
        Task task3 = new Task1();
        Task task2 = new Task2(task3);
        Task task1 = new Task3(task2);
        task1.run();
    }

    public static void main(String[] args) {
        Main.runChain();
    }
}
   