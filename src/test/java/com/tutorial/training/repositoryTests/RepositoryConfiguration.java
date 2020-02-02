package com.tutorial.training.repositoryTests;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;

@EnableAutoConfiguration
@AutoConfigureDataJpa
@AutoConfigureTestEntityManager
public class RepositoryConfiguration {

}
