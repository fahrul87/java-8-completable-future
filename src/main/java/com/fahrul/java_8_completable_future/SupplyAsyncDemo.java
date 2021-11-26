package com.fahrul.java_8_completable_future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.fahrul.java_8_completable_future.database.EmployeeDatabase;
import com.fahrul.java_8_completable_future.dto.Employee;

public class SupplyAsyncDemo {

	public List<Employee> getEmployees() throws ExecutionException, InterruptedException {
		Executor executor = Executors.newCachedThreadPool();
		CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Executed by : " + Thread.currentThread().getName());
			return EmployeeDatabase.fetchEmployees();
		}, executor);
		return listCompletableFuture.get();
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SupplyAsyncDemo supplyAsyncDemo = new SupplyAsyncDemo();
		List<Employee> employees = supplyAsyncDemo.getEmployees();
		employees.stream().forEach(System.out::println);
	}

}
