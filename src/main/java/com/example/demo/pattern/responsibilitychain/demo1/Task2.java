package com.example.demo.pattern.responsibilitychain.demo1;

/**
 * @author ansonglin
 * @className Task2
 * @description TODO
 * @date 2019/12/2 10:47
 * @cersion 1.0
 **/
public class Task2 implements Task {

    private Task task;

    Task2(){}

    Task2(Task task){
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("task2 run");
        if(null != task ){
            task.run();
        }
    }
}
   