package com.example.demo.pattern.responsibilitychain.demo3;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ansonglin
 * @className PrintProcessor
 * @description TODO
 * @date 2020/6/1 17:13
 * @cersion 1.0
 **/
public class PrintProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    private IRequestProcessor nextProcessor;

    private volatile boolean isFinish = false;

    public void shutDown() {
        isFinish = true;
    }

    public PrintProcessor() {

    }

    public PrintProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }


    @Override
    public void process(Request request) {
        requests.add(request);
    }


    @Override
    public void run() {
        System.out.println("while PrintProcessor .....");
        while (!isFinish) {
            try {
                Request request = requests.take();
                System.out.println("PrintProcessor :" + request);
                if (nextProcessor != null) {
                    nextProcessor.process(request);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
   