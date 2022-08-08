package com.example.demo.pattern.observer;

public class Client {

    public static void main(String[] args) {
        //目标对象
        ConcreteSubject concreteSubject = new ConcreteSubject();
        //多个观察者
        Observer os1 = new ObserverA();
        Observer os2 = new ObserverA();
        Observer os3 = new ObserverA();

        concreteSubject.register(os2);
        concreteSubject.register(os3);
        concreteSubject.register(os1);

        concreteSubject.setMyState(300);

        System.out.println(((ObserverA) os1).getMyState());
        System.out.println(((ObserverA) os2).getMyState());
        System.out.println(((ObserverA) os3).getMyState());

        System.out.println("###########################");
        concreteSubject.setMyState(50);
        System.out.println(((ObserverA) os1).getMyState());
        System.out.println(((ObserverA) os2).getMyState());
        System.out.println(((ObserverA) os3).getMyState());
    }


}
