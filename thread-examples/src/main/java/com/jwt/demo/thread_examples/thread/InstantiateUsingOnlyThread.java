package com.jwt.demo.thread_examples.thread;

public class InstantiateUsingOnlyThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("我运行了......");;
    }
}
