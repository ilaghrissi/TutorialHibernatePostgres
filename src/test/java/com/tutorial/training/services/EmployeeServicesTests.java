package com.tutorial.training.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tutorial.training.dto.Employee;
import com.tutorial.training.entity.EmployeeEntity;
import com.tutorial.training.repository.EmployeeRepository;
import com.tutorial.training.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts= {"classpath:scripts/insert_data.sql"},executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class EmployeeServicesTests {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Test
	public void testA() {
		Employee e = createEmployee();
		//Employee result = employeeService.addNewEmployee(e);
		EmployeeEntity ee = createEmployeeEntity();
		EmployeeEntity r = employeeRepository.save(ee);
		assertThat(r).isNotNull();
	}
	
	@Test
	public void testB() {
		List<EmployeeEntity> r = employeeRepository.getAll();
		assertThat(r).isNotEmpty();
		assertThat(r.size()).isEqualTo(1);
		assertThat(r.get(0).getEmployeeId()).isEqualTo(1344L);
	}
	
	private Employee createEmployee() {
		Employee e = new Employee();
		e.setEmployeeId(2L);
		e.setFirstName("jean");
		e.setLastName("michel");
		e.setCreatedAt(new Date());
		return e;
	}

	@Test
	@Ignore
	public void test_getEmployees() {
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		list.add(new EmployeeEntity());
		when(employeeRepository.getAll()).thenReturn(list);
		int expectedSize = 1;
		int actuelSize = employeeService.getAllEmployees().size();
		assertEquals("Must get All employees",expectedSize, actuelSize);
	}
	@Test
	@Ignore
	public void test_getEmployees_return_empty() {
		when(employeeRepository.getAll()).thenReturn(Collections.emptyList());
		int expectedSize = 0;
		int actuelSize = employeeService.getAllEmployees().size();
		assertEquals("Must get All employees",expectedSize, actuelSize);
	}

	@Test
	@Ignore
	public void test_getEmployeeById() {
		Employee actual = employeeService.getEmployeeById(1L);

	}
	
	@Test
	@Ignore
	public void test_updateEmployee() {
		EmployeeEntity e = createEmployeeEntity();
		when(employeeRepository.findById(1L)).thenReturn(Optional.of(e));
		boolean result = employeeService.updateEmployee(1L, createEmployee());
		assertThat(result).isFalse();
	}
	
	private EmployeeEntity createEmployeeEntity() {
		EmployeeEntity e = new EmployeeEntity();
		e.setEmployeeId(1L);
		e.setFirstName("jean");
		e.setLastName("michel");
		e.setCreatedAt(new Date());
		return e;
	}

	@Test
	@Ignore
	public void test_updateEmployee_not_update() {
		boolean result = employeeService.updateEmployee(1L, null);
		assertThat(result).isFalse();
	}
	
	@Test
	@Ignore
	public void test_deleteEmployee() {
		employeeService.deleteEmployee(1L);
	}
}
