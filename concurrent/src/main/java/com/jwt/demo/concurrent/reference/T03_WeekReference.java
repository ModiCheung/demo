package com.jwt.demo.concurrent.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用：可以用作一次性使用。一旦被gc看到就会被回收
 */
public class T03_WeekReference {

	public static void main(String[] args) {
		WeakReference<M> m = new WeakReference<>(new M());
		System.out.println(m.get());
		System.gc();
		System.out.println(m.get());
	}
}
