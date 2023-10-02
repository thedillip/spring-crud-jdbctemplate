package com.crud.service;

import java.util.List;

import com.crud.model.Employee;

public interface EmployeeService {
	int saveEmployee(Employee employee);

	List<Employee> findAllEmplopyee();

	Employee findEmployeeById(int id);

	int updateEmployeeById(Employee employee, int id);

	int deleteEmployeeById(int id);
}
