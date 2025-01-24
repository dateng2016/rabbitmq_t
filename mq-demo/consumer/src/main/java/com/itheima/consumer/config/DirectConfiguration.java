package com.itheima.consumer.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfiguration {
    @Bean
    public DirectExchange directExchange() {
//         ExchangeBuilder.fanoutExchange("hmall.fanout2").build();
        return new DirectExchange("hmall.direct");
    }

    @Bean
    public Queue directQueue1() {
//        QueueBuilder.durable("ff").build();
        return new Queue("direct.queue1");
    }

    @Bean
    public Binding directBinding1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with("red");
    }

    @Bean
    public Queue directQueue2() {
//        QueueBuilder.durable("ff").build();
        return new Queue("direct.queue2");
    }

    @Bean
    public Binding directBinding2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("yellow");
    }
}
