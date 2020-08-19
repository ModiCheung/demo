package com.jwt.demo.thread_examples.test;

import org.springframework.mock.web.MockHttpServletRequest;

public class Test {

    public static void main(String[] args) {
//        Thread thread = new Thread(() -> {
//            System.out.println("run111");
//        });
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().getState());


//        new HttpServletRequest();
    }
}
