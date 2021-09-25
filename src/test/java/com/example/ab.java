package com.example;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author ansonglin
 * @className ab
 * @description TODO
 * @date 2020/2/1 9:15
 * @cersion 1.0
 **/
public class ab {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        //声明并初始化一个producer
        //需要一个producer group名字作为构造方法的参数，这里为producer1
        DefaultMQProducer producer = new DefaultMQProducer("pop_logistics_sub_suc_uat");

        //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
        //NameServer的地址必须有，但是也可以通过环境变量的方式设置，不一定非得写死在代码里
        producer.setNamesrvAddr("gmq-ns-a.arch.gomeuat.com.cn:9876");
        //     producer.setVipChannelEnabled(false);//3.2。6的版本没有该设置，在更新或者最新的版本中务必将其设置为false，否则会有问题
        //调用start()方法启动一个producer实例
        producer.start();

        String trackingMsg = "{\"expressCompanyCode\":\"99900023\",\"orderNo\":\"6600205245\",\"curStatus\":\"1\",\"ischeck\":0,\"logisticsOrderNo\":\"4305624260911\",\"data\":[{\"status\":1,\"context\":\"广东东莞国美物流已揽件\",\"ftime\":\"2021-09-10 12:34:45\"}]}";


        //发送10条消息到Topic为TopicTest，tag为TagA，消息内容为“Hello RocketMQ”拼接上i的值
            try {
                Message msg = new Message("pop_logistics_sub_suc_uat",// topic
                        "pop_logistics_sub_suc",// tag
                        trackingMsg.getBytes("utf-8")// body
                );

                //调用producer的send()方法发送消息
                //这里调用的是同步的方式，所以会有返回结果
                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult.getSendStatus()); //发送结果状态
                //打印返回结果，可以看到消息发送的状态以及一些相关信息
                System.out.println(sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        //发送完消息之后，调用shutdown()方法关闭producer
        producer.shutdown();
    }
}
   