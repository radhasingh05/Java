package com.radha;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class MainApplication {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> taskQueue = new ArrayList<Integer>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
        System.out.println("Consumer and Producer");
        tProducer.start();
        tConsumer.start();

        // with Yield method
        Thread producer = new ProducerOne();
        Thread consumer = new ConsumerOne();

        producer.setPriority(8);
        consumer.setPriority(1);

        System.out.println("Yield Method");
        producer.start();
        consumer.start();

        // Join Method
        Thread t = new Thread(new Runnable()
        {
            public void run()
            {
                System.out.println("First task started");
                System.out.println("Sleeping for 2 seconds");
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("First task completed");
            }
        });
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                System.out.println("Second task started");
                System.out.println("Sleeping for 2 seconds");
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Second task completed");
            }
        });
        t.setPriority(10);
        t1.setPriority(10);
        t.start();
        t.join();
        t1.start();

        System.out.println("************ Callable **************** ");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();

        for (int i=0; i<4; i++)
        {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator  = new FactorialCalculator(number);
            Future<Integer> result = threadPoolExecutor.submit(calculator);
            resultList.add(result);
        }

        for(Future<Integer> future : resultList)
        {
            try
            {
                System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        threadPoolExecutor.shutdown();

        System.out.println("UncaughtExceptionHandler");
      /*  Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    System.out.println(Integer.parseInt("123"));
                    System.out.println(Integer.parseInt("234"));
                    System.out.println(Integer.parseInt("345"));
                    System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
                    System.out.println(Integer.parseInt("456"));
                }
            }
        });
        thread.run(); */

        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();


    }

}
