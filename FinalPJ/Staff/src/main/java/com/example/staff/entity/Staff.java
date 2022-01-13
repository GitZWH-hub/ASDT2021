package com.example.staff.entity;

//entity内仅做数据库字段的对应
public class Staff {
    /*
     * id: 员工工号
     * */
    private int id;

    /*
     * name: 员工姓名
     * */
    private String name;

    /*
     * branch: 部门
     * */
    private String branch;

    public String getBranch() {
        return branch;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
