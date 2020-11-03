package com.example.demo.rockmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RocketMqWs
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/7/14 15:43
 * @Version 1.0
 **/
@RestController
public class RocketMqWs {

    @Autowired
    private ProducerService producer;

    @RequestMapping("/push")
    public String pushMsg(String msg) {
        return producer.send("TopicTest", "push", msg);
    }
}
   