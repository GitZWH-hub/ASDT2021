package com.example.staff.rabbitmq;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user) {

        String message = JSON.toJSONString(user);
        this.rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE, "", message);


    }
}
