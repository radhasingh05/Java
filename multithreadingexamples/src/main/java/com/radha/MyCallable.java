package com.radha;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }



}
