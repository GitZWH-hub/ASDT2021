package com.example.staff.controller;

import com.example.staff.controller.Request.BranchCount;
import com.example.staff.controller.Request.ChangeBranch;
import com.example.staff.controller.Request.Register;
import com.example.staff.service.UserService;
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
public class StaffController {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);
    /**
     * 员工注册
     */
    @RequestMapping(value="/register")
    public String Rigister(@RequestBody Register req){
        LOGGER.info(" -- 注册新员工 -- ");
        return JSON.toJSONString(userService.ifRigister(req));
    }

    /*
    * 部门任务情况统计
    * */
    @RequestMapping(value="/count")
    public String BranchCount(@RequestBody BranchCount req){
        LOGGER.info(" -- 部门任务情况统计 -- ");
        return JSON.toJSONString(userService.branchCount(req));
    }

    /*
    * 员工更换部门
    * */
    @RequestMapping(value="/change")
    public String ChangeBranch(@RequestBody ChangeBranch req){
        LOGGER.info(" -- 员工更换部门 -- ");
        return JSON.toJSONString(userService.changeBranch(req));
    }
}
