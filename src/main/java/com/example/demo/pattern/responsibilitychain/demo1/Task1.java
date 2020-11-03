package com.example.demo.pattern.responsibilitychain.demo1;

/**
 * @author ansonglin
 * @className Task1
 * @description TODO
 * @date 2019/12/2 10:45
 * @cersion 1.0
 **/
public class Task1 implements Task {

    private Task task;

    public Task1() {}

    public Task1(Task task){
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("task1 run");
        if(null != task ){
            task.run();
        }
    }
}
   