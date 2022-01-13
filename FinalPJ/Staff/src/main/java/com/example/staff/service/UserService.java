package com.example.staff.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.staff.controller.Reponse.RspBranchCount;
import com.example.staff.controller.Reponse.RspRegister;
import com.example.staff.controller.Request.BranchCount;
import com.example.staff.controller.Request.ChangeBranch;
import com.example.staff.controller.Request.Register;
import com.example.staff.controller.Request.ReqUser;
import com.example.staff.entity.Staff;
import com.example.staff.mapper.UserMapper;
import com.example.staff.rabbitmq.User;
import com.example.staff.rabbitmq.FanoutSender;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FanoutSender fanoutSender;

    /*
    * 注册员工
    * */
    public RspRegister ifRigister(Register req){
        // 查询表中是否存在此员工，若存在则不予注册，若不存在则写表注册成功
        Staff staff = userMapper.findStaff(req);
        RspRegister rsp = new RspRegister();
        if(staff == null) {
            // 可注册员工
            userMapper.insertStaff(req);
            rsp.setRspMsg("注册成功");
            /*
            * 员工注册成功后，自动发送到用户服务注册（用户名：工号)
            * restTemplate.postForEntity("http://user/register", post, RspRegister.class);
            * rabbitmq发送
            * */
            User user = new User();
            user.setName(req.getId());
            fanoutSender.send(user);

            return rsp;
        }
        // 员工不可注册
        rsp.setRspMsg("用户已存在，不允许注册");
        return rsp;
    }

    /*
    * 员工情况任务统计
    * */
    public RspBranchCount branchCount(BranchCount req){
        RspBranchCount rsp = new RspBranchCount();
        // 先获取本部门ID的所有员工ID
        List<Integer> userID = userMapper.findAllStaff(req);
        System.out.println("查询得到本部门所有userid");
        System.out.println(userID);
        int finish = 0;
        for(int id: userID) {
            // 访问task微服务，得到部门ID的任务完成情况
            ReqUser userid = new ReqUser();
            userid.setId(id);
            ResponseEntity<String> msg = restTemplate.postForEntity("http://task/getstate", userid, String.class);
            JSONObject jsonObject =  JSON.parseObject(msg.getBody());
            if(jsonObject.get("state").equals("1")){
                finish++;
            }
        }
        rsp.setRspMsg("部门 " + req.getId() + " 任务完成情况");
        rsp.setFinish(finish);
        rsp.setNotFinish(userID.size() - finish);
        rsp.setId(req.getId());
        return rsp;
    }
    /*
    * 员工更换部门
    * */
    public Object changeBranch(ChangeBranch req) {
        userMapper.changeBranch(req);
        return "success";
    }
}
