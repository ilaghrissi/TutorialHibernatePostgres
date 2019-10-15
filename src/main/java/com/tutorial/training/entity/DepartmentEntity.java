package com.tutorial.training.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "DEPARTMENTS")
@Data
public class DepartmentEntity {

	@Id
	@GeneratedValue
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private Set<EmployeeEntity> employees = new HashSet<EmployeeEntity>();
	
	@ManyToOne
	@JoinColumn(name = "LOCATION_ID")
	private LocationEntity location;
	
	
	
	// https://o7planning.org/en/11223/generate-tables-from-entity-classes-in-hibernate
	// http://www.srikanthtechnologies.com/oracle/hrschema.html
	
}
