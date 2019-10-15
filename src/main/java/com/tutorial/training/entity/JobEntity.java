package com.tutorial.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "JOBS")
@Data
public class JobEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "JOB_ID")
	private Long jobId;
	
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	
	@Column(name = "MIN_SALARY")
	private Double minSalary;
	
	@Column(name = "MAX_SALARY")
	private Double maxSalary;
	
	

}
