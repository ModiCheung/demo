package com.jwt.demo.thread_examples.funture_task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class InstantiateUsingFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<String>(new CallerTask());
        Thread myThread = new Thread(futureTask);
        myThread.start();
        String returnString = futureTask.get();
        System.out.println("return: " + returnString);
    }

    public static class CallerTask implements Callable<String> {

        public String call() throws Exception {
            System.out.println("hello");
            return "hello";
        }
    }



}
