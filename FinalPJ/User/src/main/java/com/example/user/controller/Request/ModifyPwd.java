package com.example.user.controller.Request;

public class ModifyPwd {
    /*
    * 用户id
    * */
    private  int id;

    /*
    * 用户密码修改
    * */
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
