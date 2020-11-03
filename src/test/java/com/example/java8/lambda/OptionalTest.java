package com.example.java8.lambda;

import org.junit.Test;

import java.util.Optional;

/**
 * @author ansonglin
 * @className OptionalTest
 * @description java8中Optional测试
 * @date 2019/9/3 16:06
 * @cersion 1.0
 **/
public class OptionalTest {


    @Test
    public void test(){
        Person person = new Person();
        Optional<Person> person1 = Optional.ofNullable(person);
        if(!person1.isPresent()){
            System.out.println("appear null value");
        }

        Person person2 = null;
        Optional.ofNullable(person2).orElseThrow(() -> new IllegalArgumentException("object is null"));
    }
}
   