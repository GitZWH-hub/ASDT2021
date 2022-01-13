package com.example.task.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.example.task.controller.Request.AddTask;
import com.example.task.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Zhangweihua
 */
@Component
public class FanoutReceiver {

    @Autowired
    private TaskService taskService;

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutReceiver.class);

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
    public void receiveTopic1(String message) {
        User user = JSON.parseObject(message, User.class);
        LOGGER.info("【任务管理系统监听到消息】" + user.toString() + "【添加新任务】");

        AddTask req = new AddTask();
        req.setId(user.getName());
        req.setState("0");
        req.setName("初始化密码未修改");

        taskService.addTask(req);
    }
}