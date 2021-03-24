package com.jwt.demo.thread_examples;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VisibilityIssue {

	private static final int TOTAL = 10000;

	private volatile int count;

	public static void main(String[] args) {
		VisibilityIssue vi = new VisibilityIssue();

		Thread t1 = new Thread(() -> vi.add10KCount());
		Thread t2 = new Thread(() -> vi.add10KCount());
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}

		log.info("count 值为：{}", vi.count);
	}

	public synchronized void add10KCount() {
		int start = 0;
		while (start++ < TOTAL) {
			this.count++;
		}
	}
}
