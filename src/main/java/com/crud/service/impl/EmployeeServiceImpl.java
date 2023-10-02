package com.crud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.dao.EmployeeDAO;
import com.crud.model.Employee;
import com.crud.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDAO employeeDAO;

	@Override
	public int saveEmployee(final Employee employee) {
		return employeeDAO.saveEmployee(employee);
	}

	@Override
	public List<Employee> findAllEmplopyee() {
		return employeeDAO.findAllEmplopyee();
	}

	@Override
	public Employee findEmployeeById(final int id) {
		return employeeDAO.findEmployeeById(id);
	}

	@Override
	public int updateEmployeeById(final Employee employee, final int id) {
		return employeeDAO.updateEmployeeById(employee, id);
	}

	@Override
	public int deleteEmployeeById(final int id) {
		return employeeDAO.deleteEmployeeById(id);
	}
}
