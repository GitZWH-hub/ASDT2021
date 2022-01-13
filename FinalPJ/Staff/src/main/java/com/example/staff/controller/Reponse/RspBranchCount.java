package com.example.staff.controller.Reponse;

public class RspBranchCount {

    private String rspMsg;

    /*
    * 部门id
    * */
    private String id;

    /*
    * 部门完成任务数量
    * */
    private int finish;

    /*
    * 部门未完成任务数量
    * */

    private int notFinish;

    public void setId(String id) {
        this.id = id;
    }

    public int getFinish() {
        return finish;
    }

    public int getNotFinish() {
        return notFinish;
    }

    public String getId() {
        return id;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public void setNotFinish(int notFinish) {
        this.notFinish = notFinish;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }
}
