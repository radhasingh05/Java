package com.radha;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class MainApplication {

    public static void main(String[] args) throws Exception{

        // Single thread Executor with execute method which will returns void
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Async task....");
            }
        });

        executorService.shutdown();

        // Single thread Executor with submit method which will returns Future object , Callable
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        Future future = executorService1.submit(new Callable(){

            public Object call() throws Exception {
                return "Callable result";
            }
        });

        System.out.println(future.get());

        executorService1.shutdown();

        // Single thread Executor with submit method which will returns Future object , Runnable

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future future1 = executorService2.submit(new Runnable() {
            public void run() {
                System.out.println("Runnable with submit method");
            }
        });

        System.out.println(future1.get()); // get method give null if the task is completed Successfully
        executorService2.shutdown();

        // invokeAny() with Callable
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callableSet = new HashSet<Callable<String>>();
        callableSet.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });

        callableSet.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });

        callableSet.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        String result = executorService3.invokeAny(callableSet);
        System.out.println("Result = "+result);
        executorService3.shutdown();

        // invokeAll() with Callable
        ExecutorService executorService4 = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });
        List<Future<String>> futureList =executorService4.invokeAll(callables);
        for(Future<String> stringFuture : futureList){
            System.out.println("Result " + stringFuture.get());
        }
        executorService4.shutdown();

        // ThreadPoolExecutor
        System.out.println("******* ThreadPoolExecutor ********");
        ExecutorService executorService5 = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        for(int i=1;i<=5;i++){
            Task task = new Task("Task "+i);
            System.out.println("Created : "+task.getName());
            executorService5.execute(task);
        }
        executorService5.shutdown();

        // ScheduledThreadPoolExecutor
        System.out.println("******** ScheduledThreadPoolExecutor ********");
        ScheduledThreadPoolExecutor executor  = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
        Task2 task2 = new Task2("Repeat Task");
        System.out.println("Created : "+task2.getName());
        executor.scheduleWithFixedDelay(task2,5,5,TimeUnit.SECONDS);


    }
}
