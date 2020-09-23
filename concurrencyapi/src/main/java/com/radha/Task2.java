package com.radha;

import java.util.Date;

public class Task2 implements Runnable {
    private String name;

    public Task2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Executing : " + name + ", Current Seconds : " + new Date().getSeconds());
    }
}
