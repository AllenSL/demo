package com.example.java8.lambda;

import org.junit.Before;
import org.junit.Test;

public class Lambda {

    @Test
    public void testCreateThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am old style");
            }
        });
        thread.start();

        new Thread(()->{
            System.out.println("I am a method and I am running");
        },"lambda线程").start();
    }


    @Before
    public void test1(){
//        List<Person> persons = Arrays.asList(
//                new Person("allen","an",20);
//        );
    }


    public void test2(){
        String str = "hello world";
        MyLambdaInterface obj = (s) -> System.out.println(s);
    }

}
