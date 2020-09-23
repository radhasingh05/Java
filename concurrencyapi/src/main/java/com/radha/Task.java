package com.radha;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Executing : " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
