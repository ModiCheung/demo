package com.jwt.demo.concurrent.volatiled;

/**
 * 缓存行没对齐
 */
public class Cacheline_nopadding {

	public static class T {
//		private long p1,p2,p3,p4,p5,p6,p7;
		private volatile long x = 0;
	}

	private static T[] arr = new T[2];

	static {
		arr[0] = new T();
		arr[1] = new T();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (long i = 0; i < 1000_0000L; i++) {
				arr[0].x = i;
			}
		});
		Thread t2 = new Thread(() -> {
			for (long i = 0; i < 1000_0000L; i++) {
				arr[1].x = i;
			}
		});

		long startTime = System.currentTimeMillis();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("总计消耗时间：" + (System.currentTimeMillis() - startTime));
	}
}
