package com.tutorial.training.repository;

import java.util.List;

import com.tutorial.training.entity.EmployeeEntity;

public interface EmployeeCustomRepository {

	public List<EmployeeEntity> getEmployees();

	public EmployeeEntity getEmployeeById(Long id);

	public EmployeeEntity saveEmployee(EmployeeEntity emp);

	public void deleteEmployee(Long id);

	public void updateEmployee(EmployeeEntity employeeEntity);
	public List<EmployeeEntity> get();

}
