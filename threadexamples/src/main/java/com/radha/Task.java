package com.radha;

class Task implements Runnable
{
    @Override
    public void run()
    {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("234"));
        System.out.println(Integer.parseInt("345"));
        System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
        System.out.println(Integer.parseInt("456"));
    }
}
