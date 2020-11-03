package com.example.demo.rockmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;


/**
 * @Auther: Allen
 * @Date: 2018/12/15 20:31
 * @Description:
 */
public class MqProducer {
        public static void main(String[] args) throws Exception {
            //Instantiate with a producer group name.
            DefaultMQProducer producer = new
                    DefaultMQProducer("please_rename_unique_group_name");
            // Specify name server addresses.
            producer.setNamesrvAddr("192.168.68.129:9876");
            //Launch the instance.
            producer.start();
            for (int i = 0; i < 100; i++) {
                //Create a message instance, specifying topic, tag and message body.
                Message msg = new Message("TopicTest" /* Topic */,
                        "TagA" /* Tag */,
                        ("Hello RocketMQ " +
                                i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                //Call send message to deliver message to one of brokers.
                SendResult sendResult = producer.send(msg);
                System.out.printf("%s%n", sendResult);
            }
            //Shut down once the producer instance is not longer in use.
            producer.shutdown();
    }
}
