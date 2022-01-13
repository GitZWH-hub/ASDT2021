package com.example.task.controller.Request;

public class AddTask {
    /*
    * 用户id
    * */
    private int id;
    /*
    * 任务名称
    * */
    private String name;
    /*
    * 任务完成状态
    * */
    private String state;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
