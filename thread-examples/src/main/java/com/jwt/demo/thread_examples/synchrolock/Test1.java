package com.jwt.demo.thread_examples.synchrolock;

import lombok.Data;

public class Test1 {

    public static void main(String[] args) {
        RunnableTask1 runnableTask1 = new RunnableTask1();
        Thread thread1 = new Thread(runnableTask1);

        RunableTask2 runableTask2 = new RunableTask2();
        Thread thread2 = new Thread(runableTask2);

        thread1.start();
        thread2.start();

    }

    @Data
    public static class RunnableTask1 implements Runnable {

        private int num;

        public void run() {
            System.out.println("Thread-1: " + num);
        }

    }

    @Data
    public static class RunableTask2 implements Runnable {

        private int num;

        public void run() {
            System.out.println("Thread-2: " + num);
        }
    }


}
