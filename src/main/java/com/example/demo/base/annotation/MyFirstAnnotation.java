package com.example.demo.base.annotation;


import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFirstAnnotation {
    String value() default "";
}
