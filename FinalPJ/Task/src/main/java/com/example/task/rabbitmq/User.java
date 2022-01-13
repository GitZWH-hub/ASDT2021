package com.example.task.rabbitmq;

import java.io.Serializable;

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
