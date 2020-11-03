package com.example.java8.filter.service.impl;

import com.example.java8.filter.Apple;
import com.example.java8.filter.service.IApplePredicate;

public class HeavyApplePredicateImpl implements IApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor());
    }
}
