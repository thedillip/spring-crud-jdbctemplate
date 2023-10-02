package com.crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/employee-service")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;

	@PostMapping(value = "/employee")
	public ResponseEntity<String> saveEmployee(@RequestBody final Employee employee) {
		int saveCount = employeeService.saveEmployee(employee);
		if (saveCount > 0)
			return ResponseEntity.status(HttpStatus.CREATED.value()).body("Employee created");
		else
			return ResponseEntity.ok("Something went wrong");
	}

	@GetMapping(value = "/employee")
	public ResponseEntity<List<Employee>> findAllEmployee() {
		return ResponseEntity.ok(employeeService.findAllEmplopyee());
	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable final int id) {
		return ResponseEntity.ok(employeeService.findEmployeeById(id));
	}

	@PutMapping(value = "/employee/{id}")
	public ResponseEntity<String> updateEmployeeById(@RequestBody final Employee employee, @PathVariable final int id) {
		int updateCount = employeeService.updateEmployeeById(employee, id);
		if (updateCount > 0)
			return ResponseEntity.ok("Employee updated");
		else
			return ResponseEntity.ok("Something went wrong");
	}

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable final int id) {
		int updateCount = employeeService.deleteEmployeeById(id);
		if (updateCount > 0)
			return ResponseEntity.ok("Employee deleted");
		else
			return ResponseEntity.ok("Something went wrong");
	}
}
