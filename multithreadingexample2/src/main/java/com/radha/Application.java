package com.radha;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        executorService.submit(new Runnable() {
            public void run() {
                System.out.println("dzfjdzk fj sjfslf ");
            }
        });

    }
}
