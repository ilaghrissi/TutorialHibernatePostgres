package com.tutorial.training.repositoryTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.training.RepositoryConfiguration;
import com.tutorial.training.entity.EmployeeEntity;
import com.tutorial.training.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
//@Sql(scripts= {"classpath:scripts/insert_data.sql"})
public class integrationTests {
	
	@Autowired
	private EmployeeRepository emp;
	
    @LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void testSaveEmployeesInDB() {
		EmployeeEntity empE = new EmployeeEntity();
		empE.setFirstName("test 1");
		empE.setLastName("test ");
		EmployeeEntity result = emp.save(empE);
		assertNotNull(result);
	}
	
    @Test
    public void testAddEmployee() {
    	EmployeeEntity employee = new EmployeeEntity();
        ResponseEntity<String> responseEntity = this.restTemplate
            .postForEntity("http://localhost:" + port + "/employee/add", employee, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}
