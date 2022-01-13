package com.example.user.controller.Request;

public class Register {
    // 用户名
    private int name;

    private String pwd;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }
}
