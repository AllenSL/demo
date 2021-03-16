package com.example.demo.pattern.responsibilitychain.demo1;

/**
 * @author ansonglin
 * @className Task3
 * @description TODO
 * @date 2019/12/2 10:48
 * @cersion 1.0
 **/
public class Task3 implements Task {

    private Task task;

    Task3() {
    }

    Task3(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("task3 run");
        if (null != task) {
            task.run();
        }
    }
}
   