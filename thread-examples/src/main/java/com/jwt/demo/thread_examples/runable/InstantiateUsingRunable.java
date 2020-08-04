package com.jwt.demo.thread_examples.runable;

public class InstantiateUsingRunable {

    public static void main(String[] args) {
        RunableTask task1 = new RunableTask();
        RunableTask task2 = new RunableTask();
        Thread myThread1 = new Thread(task1);
        Thread myThread2 = new Thread(task2);
        myThread1.run();
        myThread2.run();
    }
}


class RunableTask implements Runnable {

    public void run() {
        System.out.println("我运行了......");
    }
}
