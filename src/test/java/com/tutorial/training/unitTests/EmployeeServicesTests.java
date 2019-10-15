package com.tutorial.training.unitTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.training.entity.EmployeeEntity;
import com.tutorial.training.repository.EmployeeRepository;
import com.tutorial.training.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServicesTests {

	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	
	@Test
	public void testGetEmployees() {
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		list.add(new EmployeeEntity());
		when(employeeRepository.getAll()).thenReturn(list);
		
		int expectedSize = 1;
		int actuelSize = employeeService.getAllEmployees().size();
		assertEquals(expectedSize,actuelSize);
	}

}
