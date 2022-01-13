package com.example.user.controller;

import com.example.user.controller.Request.Login;
import com.example.user.controller.Request.ModifyPwd;
import com.example.user.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    /**
     * 用户密码重置
     */
    @RequestMapping(value="/modifypwd")
    public String modifypwd(@RequestBody ModifyPwd req){
        LOGGER.info(" -- 用户修改密码 -- ");
        return JSON.toJSONString(userService.modifypwd(req));
    }

    /**
     * 用户登录
     */
    @RequestMapping(value="/login")
    public String login(@RequestBody Login req){
        LOGGER.info(" -- 用户登录 -- ");
        return JSON.toJSONString(userService.login(req));
    }


}
