package com.example.task.controller;

import com.example.task.controller.Request.GetTask;
import com.example.task.controller.Request.UpdatePwd;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    /**
     * 根据用户id获取任务
     */
    @RequestMapping(value="/getstate")
    public String Rigister(@RequestBody GetTask req){
        LOGGER.info(" -- 获取用户任务 -- ");
        return JSON.toJSONString(taskService.getTask(req));
    }

    /*
    * 更新用户任务状态
    * */
    @RequestMapping(value="/update")
    public String update(@RequestBody UpdatePwd req){
        LOGGER.info(" -- 更新用户任务状态 -- ");
        return JSON.toJSONString(taskService.updateTask(req));
    }

//    /*
//     * 根据用户ID获取任务完成状态
//     * */
//    @RequestMapping(value="/branchCount")
//    public int BranchCount(@RequestBody int id){
//        LOGGER.info(" -- 获取用户ID的任务状态 -- ");
//        return taskService.getUserTssk(id);
//    }

}
