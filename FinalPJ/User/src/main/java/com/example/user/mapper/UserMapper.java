package com.example.user.mapper;

import com.example.user.controller.Request.ModifyPwd;
import com.example.user.controller.Request.Register;
import com.example.user.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    User findUser(int name);
    void insertUser(Register req);
    void updateUser(ModifyPwd req);
}
