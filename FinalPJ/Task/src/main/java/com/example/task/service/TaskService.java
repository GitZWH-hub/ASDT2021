package com.example.task.service;

import com.example.task.controller.Reponse.RspGetTask;
import com.example.task.controller.Request.AddTask;
import com.example.task.controller.Request.GetTask;
import com.example.task.controller.Request.UpdatePwd;
import com.example.task.entity.Task;
import com.example.task.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 任务服务
 */
@Service
public class TaskService {

    @Autowired
    private UserMapper userMapper;

    /*
    * 添加任务
    * */
    public Object addTask(AddTask req){
        userMapper.insertTask(req);
        return "添加任务成功";
    }

     /*
     * 根据用户id查询任务
     * */
    public RspGetTask getTask(GetTask req) {
        RspGetTask rsp = new RspGetTask();

        Task task = userMapper.findTask(req.getId());

        rsp.setName(task.getName());
        rsp.setState(task.getState());

        return rsp;
    }

    /*
    * 更新用户任务状态
    * */
    public Object updateTask(UpdatePwd req){
        userMapper.updateTask(req.getId());
        return "更新成功";
    }

//    /*
//    * 获取用户状态
//    * */
//    public int getUserTssk(int id){
//        return userMapper.getUserTask(id);
//    }
}
