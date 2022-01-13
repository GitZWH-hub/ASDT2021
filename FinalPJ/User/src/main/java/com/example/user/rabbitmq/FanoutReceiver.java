package com.example.user.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.example.user.controller.Request.Register;
import com.example.user.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by Zhangweihua
 */
@Component
public class FanoutReceiver {
    @Autowired
    private UserService userService;

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutReceiver.class);

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
    public void receiveTopic1(String message) {
        User user = JSON.parseObject(message, User.class);
        LOGGER.info("【用户管理系统监听到消息】" + user.toString() + "【注册新用户】");

        Register req = new Register();
        req.setName(user.getName());
        userService.ifRigister(req);
    }
}