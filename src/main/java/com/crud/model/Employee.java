package com.crud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	private int id;
	private String city;
	private String companyName;
	private String country;
	private String email;
	private String firstName;
	private String gender;
	private String lastName;
	private String phone;
	private String state;
}
