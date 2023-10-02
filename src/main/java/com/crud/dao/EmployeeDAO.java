package com.crud.dao;

import java.util.List;

import com.crud.model.Employee;

public interface EmployeeDAO {
	int saveEmployee(Employee employee);

	List<Employee> findAllEmplopyee();

	Employee findEmployeeById(int id);

	int updateEmployeeById(Employee employee, int id);

	int deleteEmployeeById(int id);
}
