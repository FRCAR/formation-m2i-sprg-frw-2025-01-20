package com.formateur.correctionformateur.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.bigcorp.booking.correctionformateur.service"})
@PropertySource("classpath:example-application.properties")
public class SpringCorrectionConfiguration {


}
