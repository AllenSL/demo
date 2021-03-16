package com.example.demo.rockmq;

/**
 * @Auther: Allen
 * @Date: 2018/12/22 17:30
 * @Description:
 */
public class optionProducer {

//
//    public static void main(String[] args) {
//        DefaultMQProducer producer = new DefaultMQProducer("engine_group");
//        producer.setNamesrvAddr("192.168.1.130:9876");
//        try {
//            producer.start();
//            System.out.println("producer启动成功");
//            Order order = new Order();
//            order.setId(1000);
//            order.setPrice("100");
//            order.setNum("1000");
//            byte[] body = SerializationUtils.serialize(order);
//            Message msg = new Message("OptEngineTopic", "OptExecutionReport", body);
//            SendResult result = producer.send(msg);
//            System.out.println("id：" + result.getMsgId() + " result:" + result.getSendStatus());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            producer.shutdown();
//        }
//    }
}
