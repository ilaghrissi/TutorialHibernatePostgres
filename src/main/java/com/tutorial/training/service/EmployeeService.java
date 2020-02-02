package com.tutorial.training.service;

import java.util.List;

import com.tutorial.training.dto.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Long id);
	public Employee addNewEmployee(Employee employee);
	public boolean updateEmployee(Long id, Employee employee);
	public void deleteEmployee(Long id);
}
