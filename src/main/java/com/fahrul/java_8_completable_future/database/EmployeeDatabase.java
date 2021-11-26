package com.fahrul.java_8_completable_future.database;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fahrul.java_8_completable_future.dto.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDatabase {

	public static List<Employee> fetchEmployees() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File("employees.json"), new TypeReference<List<Employee>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
