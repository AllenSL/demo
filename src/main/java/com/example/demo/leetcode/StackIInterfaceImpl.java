package com.example.demo.leetcode;



public class StackIInterfaceImpl<T> implements StackIInterface<T>{

    private Object[] objects = new Object[100];
    private int index = 0;

    @Override
    public void push(T element) {
    if(index > 100 ){
        throw new IndexOutOfBoundsException();
    }
     objects[index++] = element;
    }


    @Override
    public T pop() {
        return (T) objects[-- index];
    }


    public static void main(String[] args) {
        StackIInterface imp = new StackIInterfaceImpl();
        imp.push("烦");
        imp.push("好");
        imp.push("我");
        while (true){
            System.out.println(imp.pop());
        }
    }
}
