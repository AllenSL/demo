package com.example.demo.pattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author ansonglin
 * @className OperatorFactory
 * @description
 * @date 2019/9/3 9:27
 * @cersion 1.0
 **/
public class OperatorFactory {

    static Map<String,Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("add",new Addition());
        operationMap.put("subtract",new Subtraction());
    }

    public static Optional<Operation> getOperation(String opterator){
        return Optional.ofNullable(operationMap.get(opterator));
    }

    public static void main(String[] args) {
        Operation operation = OperatorFactory.getOperation("add").orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        operation.apply(1,4);
    }
}
   