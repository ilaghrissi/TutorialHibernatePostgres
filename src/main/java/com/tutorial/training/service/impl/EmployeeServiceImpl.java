package com.tutorial.training.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tutorial.training.dto.Employee;
import com.tutorial.training.entity.EmployeeEntity;
import com.tutorial.training.mapper.EmployeeMapper;
import com.tutorial.training.repository.EmployeeCustomRepository;
import com.tutorial.training.repository.EmployeeRepository;
import com.tutorial.training.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeCustomRepository employeeCustomRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> getAllEmployees() {
		logger.info("get list of employee");
		List<EmployeeEntity> empEntities = employeeRepository.getAll();
		if(!CollectionUtils.isEmpty(empEntities)) {
			return employeeMapper.entitiesToDomains(empEntities);
		}
		return Collections.emptyList();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		EmployeeEntity empEntity = employeeCustomRepository.getEmployeeById(id);
		if(empEntity != null) {
			return employeeMapper.entityToDomain(empEntity);
		}
		return null;
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		EmployeeEntity empEntity = employeeMapper.domainToEntity(employee);
		EmployeeEntity res = employeeRepository.save(empEntity);
		if(res != null) {
			return employeeMapper.entityToDomain(res);
		}
		return null;
	}

	@Override
	public boolean updateEmployee(Long id, Employee employee) {
		Optional<EmployeeEntity> empEntity = employeeRepository.findById(id);
		if(empEntity.isPresent()) {
			EmployeeEntity newEntity = empEntity.get();
			newEntity.setEmail(employee.getEmail());
			newEntity.setFirstName(employee.getFirstName());
			newEntity.setLastName(employee.getLastName());
			newEntity.setHireDate(employee.getHireDate());
			newEntity.setJobTitle(employee.getJobTitle());
			newEntity.setPhone(employee.getPhone());
			EmployeeEntity result = employeeRepository.save(newEntity);
			if(result != null) {
				return true;
			}
			
		}
		return false;
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
