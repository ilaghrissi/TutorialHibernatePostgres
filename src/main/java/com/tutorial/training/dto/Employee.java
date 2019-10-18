package com.tutorial.training.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Employee {

	@ApiModelProperty(notes = "employee id")
	private Long employeeId;

	@ApiModelProperty(notes = "employee first name")
	private String firstName;

	@ApiModelProperty(notes = "employee last name")
	private String lastName;

	@ApiModelProperty(notes = "employee email address")
	private String email;

	@ApiModelProperty(notes = "employee phone")
	private String phone;

	@ApiModelProperty(notes = "employee hiredate")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date hireDate;

	@ApiModelProperty(notes = "employee job title")
	private String jobTitle;
	
	@ApiModelProperty(notes = "employee manager")
	private Employee manager;
	
	@ApiModelProperty(notes = "created date of employee")
	private Date createdAt;
	
	@ApiModelProperty(notes = "last update date of employee")
	private Date updatedAt;

}
