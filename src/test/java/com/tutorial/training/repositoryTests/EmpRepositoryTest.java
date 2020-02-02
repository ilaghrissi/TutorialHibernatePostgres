package com.tutorial.training.repositoryTests;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/*@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,classes = RepositoryConfiguration.class)
@ActiveProfiles({"H2","test"})
@Transactional
@Sql("/init-database.sql")*/
public class EmpRepositoryTest {
	
	// this class used to test just repository
	
	// test : unitaire : logique métier il faut mocker les repository
	// test : integration : utilisation des configuration d'une environnement (config, base de données,...)
	// pas de mock on test sur des vrais données soit avec une base memoire comme H2 ou une base existants
	// par exemple la recette, l'integration, la dev 
	// test : repository : test que les requêtes (comme cette classe mais qu'elle se base sur une base H2)

}
