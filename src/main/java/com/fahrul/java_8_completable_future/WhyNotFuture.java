package com.fahrul.java_8_completable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WhyNotFuture {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10);

		Future<List<Integer>> future = service.submit(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
			System.out.println(10 / 0);
			return Arrays.asList(1, 2, 3, 4);
		});

		List<Integer> integers = future.get();
		System.out.println(integers);

		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		completableFuture.get();
		completableFuture.complete("return some dummy data......");
	}

	public static void delay(int min) {
		try {
			TimeUnit.MINUTES.sleep(min);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
