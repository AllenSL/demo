package com.example.demo.pattern.responsibilitychain.demo3;

/**
 * @author ansonglin
 * @className Test
 * @description TODO
 * @date 2020/6/1 17:32
 * @cersion 1.0
 **/
public class Test {

    static IRequestProcessor iRequestProcessor;

    public Test() {

    }

    public void setUp() {
        PrintProcessor printProcessor = new PrintProcessor();
        printProcessor.start();
        SaveProcessor saveProcessor = new SaveProcessor(printProcessor);
        saveProcessor.start();
        iRequestProcessor = new PreProcessor(saveProcessor);
        ((PreProcessor) iRequestProcessor).start();

    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setUp();
        Request request = new Request();
        request.setName("Allen");
        iRequestProcessor.process(request);
    }
}
   