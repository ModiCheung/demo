package com.jwt.demo.concurrent.future;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFuture {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		System.out.println(LocalDateTime.now());
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> futureTask = executor.submit(() -> {
			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 1;
		});
		System.out.println(futureTask.get());
		System.out.println(LocalDateTime.now());
	}
}
