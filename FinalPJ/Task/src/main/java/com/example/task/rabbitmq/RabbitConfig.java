package com.example.task.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    //fanout
    public static final String FANOUT_QUEUE2 = "fanout.queue2";
    public static final String FANOUT_EXCHANGE = "fanout.exchange";

    @Bean
    public Queue fanoutQueue2() {
        return new Queue(FANOUT_QUEUE2);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

}