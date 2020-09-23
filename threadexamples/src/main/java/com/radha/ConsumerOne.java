package com.radha;

public class ConsumerOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }

}
