package com.formateur.cours.core.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import com.formateur.cours.core.service.EmployeeService;

/**
 * Bean de configuration : fournit à Spring
 * des configurations par annotations
 * et d'autres beans dans le contexte grâce aux méthodes
 * annotées avec @Bean
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.bigcorp.booking.cours.core.service", "com.bigcorp.booking.cours.core.aspect"})
@PropertySource("classpath:example-application.properties")
public class SpringCoursConfiguration {

    @Bean
    public EmployeeService employeeService(@Value("#{companyService.generateRandom}") Integer maxCompanyId) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.setEtage("3eme");
        System.out.println("J'ai récupéré le maxCompanyId : " + maxCompanyId);
        return employeeService;
    }

}
