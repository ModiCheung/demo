package com.jwt.demo.concurrent.volatiled;

/**
 * DCL Double-Check Lock 双重检查锁定
 * DCL单例模式
 */
public class DCLSington {

	private static volatile DCLSington INSTANCE;

	private DCLSington() {
	}

	public static DCLSington getInstance() {
		if (INSTANCE == null) {
			synchronized (DCLSington.class) {
				if (INSTANCE == null) {
					INSTANCE = new DCLSington();
				}
			}
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		DCLSington ins = DCLSington.getInstance();
	}
}
