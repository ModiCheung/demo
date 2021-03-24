package com.jwt.demo.concurrent;

public class DeadLockDemo {

    private String A = "A";
    private String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    public void deadLock() {
        Thread a = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.currentThread().sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("A");
                }
            }

        });

        Thread b = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("B");
                }
            }
        });
        a.start();
        b.start();
    }
}
