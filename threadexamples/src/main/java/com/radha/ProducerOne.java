package com.radha;

public class ProducerOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}
