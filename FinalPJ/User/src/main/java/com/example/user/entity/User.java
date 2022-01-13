package com.example.user.entity;

//entity内仅做数据库字段的对应
public class User {
    // 用户名（工号）
    private int name;

    // 用户密码
    private String pwd;

    public void setName(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
