package com.example.demo.pattern.responsibilitychain.demo3;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ansonglin
 * @className PreProcessor
 * @description TODO
 * @date 2020/6/1 17:18
 * @cersion 1.0
 **/
public class PreProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    private IRequestProcessor nextProcessor;

    private volatile boolean isFinish = false;

    public void shutDown(){
        isFinish = true;
    }

    public PreProcessor() {
    }

    public PreProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }


    @Override
    public void process(Request request) {
      requests.add(request);
    }



    @Override
    public void run(){
        System.out.println("while PreProcessor .....");
        while (!isFinish){
            try {
                //阻塞式获取元素
                Request request = requests.take();
                System.out.println("PreProcessor :"+request);
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
   