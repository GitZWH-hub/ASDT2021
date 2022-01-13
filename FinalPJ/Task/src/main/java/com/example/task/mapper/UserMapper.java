package com.example.task.mapper;

import com.example.task.controller.Request.AddTask;
import com.example.task.controller.Request.GetTask;
import com.example.task.entity.Task;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    Task findTask(int id);
    void insertTask(AddTask req);
    void updateTask(int id);

//    int getUserTask(int id);
}
