package com.tutorial.training.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.tutorial.training.dto.Employee;
import com.tutorial.training.entity.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	
	
	EmployeeEntity domainToEntity(Employee employee); 
	
	Employee entityToDomain(EmployeeEntity employeeEntity);
	
	@IterableMapping(elementTargetType = Employee.class)
	List<Employee> entitiesToDomains(List<EmployeeEntity> employeeEntities);

}
