package com.jwt.demo.thread_examples;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

	public static void main(String[] args) throws InterruptedException {
		// test park
		System.out.println(System.currentTimeMillis());
		Thread t1 = new Thread(() -> {
			try {
				Thread.currentThread().sleep(5000L);
				System.out.println("t1线程睡眠5s后...");
				LockSupport.park();
				System.out.println(System.currentTimeMillis());
				LockSupport.park();
				System.out.println(System.currentTimeMillis());
				System.out.println("线程执行了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
		Thread.currentThread().sleep(3000L);
		LockSupport.unpark(t1);
		System.out.println("主线程执行完成");
	}
}
