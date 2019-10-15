package com.tutorial.training.repositoryTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.training.entity.EmployeeEntity;
import com.tutorial.training.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTests {
	
	@Autowired
	private EmployeeRepository emp;
	
	@Test
	public void testSaveEmployeesInDB() {
		EmployeeEntity empE = new EmployeeEntity();
		empE.setFirstName("test 1");
		empE.setLastName("test ");
		EmployeeEntity result = emp.save(empE);
		assertNotNull(result);
	}

}
