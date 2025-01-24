package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    void testSendMessage2Queue() {
        String queueName = "simple.queue";
        String msg = "Hello, amqp2";
        rabbitTemplate.convertAndSend(queueName, msg);
    }

    @Test
    void testWorkQueue() throws InterruptedException {
        for (int i = 1; i <= 50; i++) {
            String queueName = "work.queue";
            String msg = "Hello, worker, message_" + i;
            rabbitTemplate.convertAndSend(queueName, msg);
            Thread.sleep(20);
        }
    }

    @Test
    void testSendFanout() {
        // This is sending message to an EXCHANGE, NOT a queue.
        String exchangeName = "hmall.fanout";

        String msg = "Hello, everyone, this is a FANOUT message";
        rabbitTemplate.convertAndSend(exchangeName, "", msg);
        // NOTE: Since we are sending the message to an EXCHANGE, there should
        // be an extra argument of 'routingKey'.
    }

    @Test
    void sendDirect() {
        String exchangeName = "hmall.direct";
        String msg = "Hello, everyone, this is a DIRECT message";
        String redMessage = "Hi, this is a RED message";
        String blueMessage = "Hi, This is a BLUE message";
        // rabbitTemplate.convertAndSend(exchangeName, "red", redMessage);
        rabbitTemplate.convertAndSend(exchangeName, "blue", blueMessage);
    }

    @Test
    void sendTopic() {
        String exchangeName = "hmall.topic";
        String msg = "Hello, everyone, this is a TOPIC message";
        String weatherMsg = "Hi, this is a WEATHER message";
        // rabbitTemplate.convertAndSend(exchangeName, "japan.news", msg);
        rabbitTemplate.convertAndSend(exchangeName, "china.weather", weatherMsg);
    }

    @Test
    void sendObject() {
        Map<String, Object> msg = new HashMap<>(2);
        msg.put("name", "jack");
        msg.put("age", 81);
        rabbitTemplate.convertAndSend("object.queue",msg);
    }
}
