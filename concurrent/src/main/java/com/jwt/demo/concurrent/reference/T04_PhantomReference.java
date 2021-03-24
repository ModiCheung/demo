package com.jwt.demo.concurrent.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用：指向堆外内存。当对象被回收时，会放入指定queue里，对应的gc线程会回收该对象对应堆外内存
 */
public class T04_PhantomReference {

	private static final List<Object> LIST = new LinkedList<>();
	private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

	public static void main(String[] args) {
		PhantomReference<M> pr = new PhantomReference<>(new M(), QUEUE);
		new Thread(() -> {
			while (true) {
				LIST.add(new byte[1024*1024]);
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
				System.out.println(pr.get());
			}
		}).start();

		new Thread(() -> {
			Reference<? extends M> poll = QUEUE.poll();
			if (poll != null) {
				System.out.println("--- 虚引用对象被jvm回收了 --- " + poll);
			}
		}).start();
	}
}
