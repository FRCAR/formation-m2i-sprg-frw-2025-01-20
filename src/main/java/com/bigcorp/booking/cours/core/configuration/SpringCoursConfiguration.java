package com.bigcorp.booking.cours.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bigcorp.booking.cours.core.service.EmployeeService;

@Configuration
@ComponentScan("com.bigcorp.booking.cours.core.service")
public class SpringCoursConfiguration {

    @Bean
    public EmployeeService employeeService() {
        EmployeeService employeeService = new EmployeeService();
        employeeService.setEtage("3eme");
        return employeeService;
    }

}
