package com.example.java8.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/7/1 9:36
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

   private String firstName;

   private String lastName;

   private int age;


}
   