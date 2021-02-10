package com.tutorial.training.repositoryTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.tutorial.training.entity.EmployeeEntity;
import com.tutorial.training.repository.EmployeeRepository;

/*@RunWith(SpringRunner.class)
@DataJpaTest*/
public class EmployeeRepositoryTests {
	
	/*@Autowired
	private EmployeeRepository emp;
	
	@Test
	public void testSaveEmployeesInDB() {
		EmployeeEntity empE = new EmployeeEntity();
		empE.setFirstName("test 1");
		empE.setLastName("test ");
		EmployeeEntity result = emp.save(empE);
		assertNotNull(result);
	}*/
	
    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");        
    }
    @Before
    public void before(){
        System.out.println("before");
    }
	@Test
	@Ignore
	public void getEmployees(){
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
		  = "https://www.etude-emploi.fr//api/offers/";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(fooResourceUrl, String.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

}
