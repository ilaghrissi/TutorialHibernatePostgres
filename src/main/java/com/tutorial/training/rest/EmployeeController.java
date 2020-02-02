package com.tutorial.training.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.training.dto.Employee;
import com.tutorial.training.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ApiOperation(value = "View a list of available employee", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		logger.info("Get all employee");
		List<Employee> employee = employeeService.getAllEmployees();
		return ResponseEntity.ok().body(employee);
	}

	@ApiOperation(value = "Get employee by given id")
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		logger.info("id : {}", id);
		Employee employee = employeeService.getEmployeeById(id);
		return ResponseEntity.ok().body(employee);
	}

	@ApiOperation(value = "Add new employee")
	@PostMapping(value = "/add",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
		logger.info("name : {}", employee.getHireDate());
		Employee e = employeeService.addNewEmployee(employee);
		return ResponseEntity.ok().body(e);
	}

	@ApiOperation(value = "Update an employee")
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Void> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Delete an employee")
	@DeleteMapping(value = "/delete/{id}")
	public void deleteEmployee(@PathVariable(name = "id") Long id) {
		employeeService.deleteEmployee(id);
	}
}
