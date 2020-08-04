package com.jwt.demo.thread_examples.thread;

public class InstantiateUsingOnlyThread2 {

    public static void main(String[] args) {

        System.out.println("Thread main started");

        MyThread myThread = new MyThread();
        myThread.run();

        System.out.println("Thread main finished");
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            System.out.println(this);
        }
    }

}
