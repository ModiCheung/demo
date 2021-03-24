package com.jwt.demo.concurrent;

public class MultiThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(Thread.currentThread().getName());
        myThread.start();
    }

    static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("我是MyThread");
        }
    }
}
