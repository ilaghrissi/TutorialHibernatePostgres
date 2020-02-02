package emp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EmployeeTests {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");        
    }
    @Before
    public void before(){
        System.out.println("before");
    }

	@Test
	public void getEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://www.etude-emploi.fr//api/offers/";
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
		System.out.println("response" + response.getBody());
		System.out.println("response ok");
	}
	
    @After
    public void after(){
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");        
    }
}
