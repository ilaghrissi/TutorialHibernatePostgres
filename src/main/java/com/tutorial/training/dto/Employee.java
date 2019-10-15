package com.tutorial.training.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Employee {

	private Long employeeId;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date hireDate;

	private String jobTitle;
	
	private Employee manager;
	
	private Date createdAt;
	private Date updatedAt;

}
