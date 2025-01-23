package com.itheima.consumer.listeners;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg) {
        System.out.println("The consumer received message from simple.queue: " + msg);
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg) {
        System.out.println("The consumer 1 received message from work.queue: " + msg);
    }


    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.out.println("The consumer 2 received message from work.queue: " + msg);
        Thread.sleep(200);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) {
        System.out.println("The consumer 1 received message from fanout.queue1: " + msg);
    }


    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) throws InterruptedException {
        System.out.println("The consumer 2 received message from fanout.queue2: " + msg);
        Thread.sleep(200);
    }

    @RabbitListener(queues = "direct.queue1")
    public void listenDirectQueue1(String msg) {
        System.out.println("The consumer 1 received message from direct.queue1: " + msg);
    }


    @RabbitListener(queues = "direct.queue2")
    public void listenDirectQueue2(String msg) throws InterruptedException {
        System.out.println("The consumer 2 received message from direct.queue2: " + msg);
        Thread.sleep(200);
    }

    @RabbitListener(queues = "topic.queue1")
    public void listenTopicQueue1(String msg) {
        System.out.println("The consumer 1 received message from topic.queue1: " + msg);
    }


    @RabbitListener(queues = "topic.queue2")
    public void listenTopicQueue2(String msg) throws InterruptedException {
        System.out.println("The consumer 2 received message from topic.queue2: " + msg);
        Thread.sleep(200);
    }

}
