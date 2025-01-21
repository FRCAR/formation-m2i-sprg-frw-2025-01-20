package com.bigcorp.booking.correctionformateur.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import com.bigcorp.booking.cours.core.service.EmployeeService;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.bigcorp.booking.correctionformateur.service"})
@PropertySource("classpath:example-application.properties")
public class SpringCorrectionConfiguration {


}
