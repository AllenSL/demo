package com.example.java8.filter;

import com.example.java8.filter.service.IApplePredicate;
import com.example.java8.filter.service.impl.GreenApplePredicateimpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * JAVA8新特性 数据过滤测试
 */
public class Filter {

    private List<Apple> inventory;

    @Before
    public void init() {
        inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
    }

    @Test
    public void test1() {
        List<Apple> apples = filterApple(inventory, Filter::isGreenApple);
        System.out.println(apples);
        List<Apple> redApples = filterApple(inventory, Filter::isRedApple);
        System.out.println("redApples: " + redApples);
    }


    @Test
    public void test2() {
        //这种写法实在是太骚气了
        List<Apple> greenApples = filterApple(inventory, (Apple a) -> "green".equals(a.getColor()));
        List<Apple> appleList = filterApple(inventory, (Apple a) -> "green".equals(a.getColor()) || a.getWeight() > 120);
        System.out.println("greenApples: " + appleList);

    }

    @Test
    public void test3() {
        //此种写法更为霸道
        //顺序处理
        List<Apple> greenApples = inventory.stream().filter((Apple a) -> "green".equals(a.getColor())).collect(Collectors.toList());
        System.out.println("greenApples:" + greenApples);

        //并行处理
        List<Apple> apples = inventory.parallelStream().filter((Apple a) -> "green".equals(a.getColor())).collect(Collectors.toList());
        System.out.println("greenApples:" + greenApples);
    }

    @Test
    public void test4() {
        IApplePredicate iApplePredicate = new GreenApplePredicateimpl();
        List<Apple> apples = filterApples(inventory, iApplePredicate);
        System.out.println(apples);
    }

    @Test
    public void test5(){
        filterApples(inventory, new IApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return false;
            }
        });
    }

    @Test
    public void test6(){
        inventory.sort(( a,  b) -> a.getWeight().compareTo(b.getWeight()));
        System.out.println(inventory);
    }



    public static List<Apple> filterApples(List<Apple> inventory,
                                           IApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApple(List<Apple> list, Predicate<Apple> predicate) {
        List<Apple> filterList = new ArrayList<Apple>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                filterList.add(apple);
            }
        }
        return filterList;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isRedApple(Apple apple) {
        return "red".equals(apple.getColor());
    }

    ;
}
