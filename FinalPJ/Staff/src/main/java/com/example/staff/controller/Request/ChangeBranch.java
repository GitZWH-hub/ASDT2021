package com.example.staff.controller.Request;

public class ChangeBranch {
    /*
    * 员工ID
    * */
    private int id;
    /*
    * 员工更换部门ID
    * */
    private String branchID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }
}
