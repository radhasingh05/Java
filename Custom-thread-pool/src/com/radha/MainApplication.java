package com.radha;

public class MainApplication {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2);

        for (int i = 1; i <= 5; i++)
        {
            Task task = new Task("Task " + i);
            System.out.println("Created : " + task.getName());

            customThreadPool.execute(task);
        }

       // customThreadPool.shutdown();

    }
}
