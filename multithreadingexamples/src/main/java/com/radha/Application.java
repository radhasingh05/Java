package com.radha;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {

    public static void main(String[] args) throws Exception {

        MyCallable myCallable = new MyCallable();
        String result = myCallable.call();
        System.out.println(result);

        System.out.println("Using ExecutorService");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> stringFuture =executorService.submit(myCallable);
        System.out.println(stringFuture.get());
        executorService.shutdown();

        System.out.println("Using Multiple threads");
        List<Future<String>> list = new ArrayList<Future<String>>();
        ExecutorService executorServices = Executors.newFixedThreadPool(10);
        for(int i=0;i<=20;i++){
            Future<String> stringFutures =executorServices.submit(myCallable);
            list.add(stringFutures);
        }

        for(Future<String> future : list){
            System.out.println(new Date()+" : "+future.get());
        }
        executorServices.shutdown();

    }
}
