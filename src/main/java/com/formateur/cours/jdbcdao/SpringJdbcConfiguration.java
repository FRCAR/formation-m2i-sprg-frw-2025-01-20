package com.formateur.cours.jdbcdao;

import javax.sql.DataSource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//Déclare un bean de configuration
//ce bean va créer d'autres instances
@Configuration

//Scanne les composants trouvés dans le
//package fourni en paramètre
@ComponentScan("com.bigcorp.booking.cours.jdbcdao")
@PropertySource("classpath:example-application.properties")
public class SpringJdbcConfiguration {

	//A supprimer quand on passe en JPA
	// @Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/h2-data/formation-spring-framework");
		dataSource.setUsername("h2");
		dataSource.setPassword("");

		return dataSource;
	}

}