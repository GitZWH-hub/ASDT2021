package com.example.task.controller.Reponse;

public class RspGetTask {
    /*
     * 任务名称
     * */
    private String name;
    /*
     * 任务完成状态
     * */
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
