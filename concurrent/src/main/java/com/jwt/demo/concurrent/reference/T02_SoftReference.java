package com.jwt.demo.concurrent.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用：主要用于缓存。内存足够的时候不会清理，如果内存不够的话即使软引用存在也会进行清理
 */
public class T02_SoftReference {

	public static void main(String[] args) {
		SoftReference<byte[]> sr = new SoftReference<>(new byte[1024 * 1024 * 10]);
		System.out.println(sr.get());
		System.gc();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(sr.get());
		byte[] b = new byte[1024 * 1024 * 15];
		System.out.println(sr.get());
	}




}
