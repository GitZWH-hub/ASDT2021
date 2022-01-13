package com.example.user.service;

import com.example.user.controller.Reponse.RspRegister;
import com.example.user.controller.Request.Login;
import com.example.user.controller.Request.ModifyPwd;
import com.example.user.controller.Request.Register;
import com.example.user.entity.User;
import com.example.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户服务
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    /*
    * 注册用户验证是否存在
    * */
    public RspRegister ifRigister(Register req){
        // 查询表中是否存在此用户，若存在则不予注册，若不存在则写表注册成功
        User user = userMapper.findUser(req.getName());
        RspRegister rsp = new RspRegister();
        if(user == null) {
            // 创建随机密码
            Integer randNum = (int)(Math.random()* (999999)+1);//产生(0,999999]之间的随机数
            String workPassWord = String.format("%06d",randNum);//进行六位数补全
            req.setPwd(workPassWord);
            LOGGER.info("用户 " + req.getName() + " 生成的随机密码为：" + workPassWord);
            // 代表用户可注册，所以要insert into相应的用户表
            userMapper.insertUser(req);
            rsp.setRspMsg("用户注册成功");

            // 发送到任务系统，添加一条待修改密码登录密码的任务

            return rsp;
        }
        rsp.setRspMsg("用户已存在，不允许注册");
        return rsp;
    }

    /*
     * 更新用户密码
     * */
    public RspRegister modifypwd(ModifyPwd req){
        RspRegister rsp = new RspRegister();
        //先查询用户是否存在，存在则修改，否则返回用户不存在
        User user = userMapper.findUser(req.getId());
        if (user == null) {
            rsp.setRspMsg("用户不存在，不能修改密码");
            return rsp;
        }
        userMapper.updateUser(req);
        rsp.setRspMsg("修改成功");
        // 用户修改密码后，通知任务管理系统更新状态
        restTemplate.postForEntity("http://task/update", req , String.class);
        return rsp;
    }
    /*
     * 用户登录
     * */
    public RspRegister login(Login req){
        RspRegister rsp = new RspRegister();
        //先查询用户是否存在
        User user = userMapper.findUser(req.getId());
        if (user == null) {
            rsp.setRspMsg("用户不存在，无法登录");
            return rsp;
        }
        if (user.getPwd().equals(req.getPwd()))
            rsp.setRspMsg("用户登录成功");
        else{
            rsp.setRspMsg("登录密码错误，不允许登录");
        }
        return rsp;
    }
}
