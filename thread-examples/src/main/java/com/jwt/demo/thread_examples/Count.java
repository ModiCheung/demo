package com.jwt.demo.thread_examples;

public class Count {

	public static void main(String[] args) throws InterruptedException {
		Count c = new Count();
		for (int i = 0; i < 10000; i++) {
			Thread t = new Thread(() -> Count.increment());
			t.start();
		}
		Thread.sleep(3000L);
		System.out.println(count);
	}

	static int count = 0;

	static void increment() {
//		int copy = count;
//		do {
//			int copy = count;
//			int newCount = count + 1;
//		} while (compareAndSet);
//		count++;
	}
}
