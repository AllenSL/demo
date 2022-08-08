package com.example.demo.leetcode;

import java.util.LinkedList;

public class MyStack {

   private LinkedList<Object> list;

   public MyStack(){
       list = new LinkedList<>();
   }

   public void push(Object obj ){
       list.add(obj);
   }

   public Object pop(){
       Object o = list.get(list.size() - 1);
       list.remove(list.size() - 1);
       return o;
   }

   public Object peek(){
       return list.get(list.size() - 1);
   }

}



