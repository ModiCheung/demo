package com.jwt.demo.concurrent.reference;

public class M {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}

}
