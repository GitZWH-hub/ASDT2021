package com.example.task.entity;

//entity内仅做数据库字段的对应
public class Task {
    /*
    * 用户名（工号）
    * */
    private int id;

    /*
    * 任务名称
    * */
    private String name;

    /*
     * 任务状态
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
