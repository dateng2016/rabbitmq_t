package com.itheima.consumer.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfiguration {
    @Bean
    public FanoutExchange fanoutExchange() {
//         ExchangeBuilder.fanoutExchange("hmall.fanout2").build();
        return new FanoutExchange("hmall.fanout2");
    }

    @Bean
    public Queue fanoutQueue3() {
//        QueueBuilder.durable("ff").build();
        return new Queue("fanout.queue3");
    }

    @Bean
    public Binding fanoutBinding3(Queue fanoutQueue3, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }
}
