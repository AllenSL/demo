package com.example.demo.pattern.responsibilitychain.demo3;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ansonglin
 * @className SaveProcessor
 * @description TODO
 * @date 2020/6/1 17:18
 * @cersion 1.0
 **/
public class SaveProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    private final IRequestProcessor nextProcessor;

    private volatile boolean isFinish = false;

    public void shutDown(){
        isFinish = true;
    }
    public SaveProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }


    @Override
    public void process(Request request) {
        requests.add(request);
    }

    @Override
    public void run(){
        System.out.println("while SaveProcessor .....");
        while (!isFinish){
            try {
                Request request = requests.take();
                System.out.println("SaveProcessor :"+request);
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
   