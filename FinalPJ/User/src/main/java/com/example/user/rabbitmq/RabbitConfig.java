package com.example.user.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    //fanout
    public static final String FANOUT_QUEUE1 = "fanout.queue1";
    public static final String FANOUT_EXCHANGE = "fanout.exchange";



    /**
     * Fanout模式
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     * @return
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue(FANOUT_QUEUE1);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

}