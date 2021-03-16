package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

public class SingletonDemo {

    private volatile static SingletonDemo instance;

    private SingletonDemo() {
    }

    public SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    return new SingletonDemo();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(7);
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(2);
        int temp = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 1; j < list.size() - i; j++) {
                Integer a;
                if (list.get(j - 1).compareTo(list.get(j)) > 0) { // 比较两个整数的大小
                    a = list.get(j - 1);
                    list.set((j - 1), list.get(j));
                    list.set(j, a);//交换数据
                }
            }
            System.out.println(list);
        }

//        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
//        int temp=0;
//        for(int i=0;i<a.length-1;i++){
//            for(int j=0;j<a.length-1-i;j++){
//                if(a[j]>a[j+1]){
//                    temp=a[j];
//                    a[j]=a[j+1];
//                    a[j+1]=temp;
//                }
//            }
//        }
//

    }
}
