package com.crud.dao.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.crud.dao.EmployeeDAO;
import com.crud.model.Employee;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public int saveEmployee(final Employee employee) {
		final String sqlQuery = "INSERT INTO public.employee (id, city, company_name, country, email, first_name, gender, last_name, phone, state) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		int saveCount = jdbcTemplate.update(sqlQuery,
				new Object[] { employee.getId(), employee.getCity(), employee.getCompanyName(), employee.getCountry(),
						employee.getEmail(), employee.getFirstName(), employee.getGender(), employee.getLastName(),
						employee.getPhone(), employee.getState() },
				new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR });
		return saveCount;
	}

	@Override
	public List<Employee> findAllEmplopyee() {
		final String sqlQuery = "SELECT id, city, company_name, country, email, first_name, gender, last_name, phone, state FROM public.employee;";
		RowMapper<Employee> rowMapper = (rs, rowNum) -> {
			return Employee.builder().id(rs.getInt("id")).city(rs.getString("city"))
					.companyName(rs.getString("company_name")).country(rs.getString("country"))
					.email(rs.getString("email")).firstName(rs.getString("first_name")).gender(rs.getString("gender"))
					.lastName(rs.getString("last_name")).phone(rs.getString("phone")).state(rs.getString("state"))
					.build();
		};

		List<Employee> finalEmployeeList = jdbcTemplate.query(sqlQuery, rowMapper);
		return finalEmployeeList;
	}

	@Override
	public Employee findEmployeeById(final int id) {
		final String sqlQuery = "SELECT id, city, company_name, country, email, first_name, gender, last_name, phone, state FROM public.employee WHERE id = ?;";

		RowMapper<Employee> rowMapper = (rs, rowNum) -> {
			return Employee.builder().id(rs.getInt("id")).city(rs.getString("city"))
					.companyName(rs.getString("company_name")).country(rs.getString("country"))
					.email(rs.getString("email")).firstName(rs.getString("first_name")).gender(rs.getString("gender"))
					.lastName(rs.getString("last_name")).phone(rs.getString("phone")).state(rs.getString("state"))
					.build();
		};

		Employee employee = jdbcTemplate.queryForObject(sqlQuery, rowMapper, id);
		return employee;
	}

	@Override
	public int updateEmployeeById(final Employee employee, final int id) {
		final String sqlQuery = "UPDATE public.employee SET city=?, company_name=?, country=?, email=?, first_name=?, gender=?, last_name=?, phone=?, state=? WHERE id=?;";

		int updateCount = jdbcTemplate.update(sqlQuery,
				new Object[] { employee.getCity(), employee.getCompanyName(), employee.getCountry(),
						employee.getEmail(), employee.getFirstName(), employee.getGender(), employee.getLastName(),
						employee.getPhone(), employee.getState(), id },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER });

		return updateCount;
	}

	@Override
	public int deleteEmployeeById(final int id) {
		final String sqlQuery = "DELETE FROM public.employee WHERE id=?;";
		int deleteCount = jdbcTemplate.update(sqlQuery, new Object[] { id }, new int[] { Types.INTEGER });
		return deleteCount;
	}
}
