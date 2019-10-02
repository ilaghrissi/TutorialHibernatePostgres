package com.tutorial.training.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.training.dto.Employee;
import com.tutorial.training.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok().body(employeeService.getAllEmployees());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {		
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
		System.out.println("name : "+employee.getHireDate());
		Employee e = employeeService.addNewEmployee(employee);
		return ResponseEntity.ok().body(e);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable(name = "id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
