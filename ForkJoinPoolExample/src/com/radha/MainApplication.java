package com.radha;

import java.util.concurrent.ForkJoinPool;

public class MainApplication {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("********* RecursiveAction *********");

        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(48);

        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        forkJoinPool.invoke(myRecursiveAction);

        Thread.sleep(10000);

        System.out.println("******** RecursiveTask **********");

        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);

        ForkJoinPool forkJoinPool1 = new ForkJoinPool(2);

        long mergedResult = forkJoinPool1.invoke(myRecursiveTask);

        System.out.println("mergedResult = " + mergedResult);


    }
}
