package com.example.user.rabbitmq;

import java.io.Serializable;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/9
 */
public class User implements Serializable {
    private int name;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                '}';
    }
}
