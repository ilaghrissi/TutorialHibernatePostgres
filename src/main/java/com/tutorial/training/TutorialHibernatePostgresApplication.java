package com.tutorial.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class TutorialHibernatePostgresApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TutorialHibernatePostgresApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.regex("/.*"))
				.apis(RequestHandlerSelectors.basePackage("com.tutorial.training.rest"))
				.build()
				.apiInfo(apiDetails());
		
	}
	   private ApiInfo apiDetails() {
	        return new ApiInfoBuilder().title("REST API Documentation")
		        .description("Api Documentation for rest webservices using swagger 2")
	            .contact(new Contact("imad LAGHRISSI", "http://www.imad-laghrissi.com", "laghrissi.imad@gmail.com"))
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .version("1.0.0")
	            .build();
	    }

}
