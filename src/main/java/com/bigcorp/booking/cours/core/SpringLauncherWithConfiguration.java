package com.bigcorp.booking.cours.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.cours.core.configuration.SpringCoursConfiguration;
import com.bigcorp.booking.cours.core.service.CompanyService;
import com.bigcorp.booking.cours.core.service.EmployeeService;

public class SpringLauncherWithConfiguration {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext appContext 
            = new AnnotationConfigApplicationContext(SpringCoursConfiguration.class)) {

            CompanyService companyServiceQuiVientDeSpring = appContext.getBean(CompanyService.class);
            // CompanyService monBeanQuiVientDeSpring = new CompanyService();
            companyServiceQuiVientDeSpring.setName("Salut");
            System.out.println(companyServiceQuiVientDeSpring.getName());
            // OrderService orderServiceQuiVientDeSpring = appContext.getBean(OrderService.class);
            // System.out.println(orderServiceQuiVientDeSpring.getMaxOrderNumber());
            System.out.println("Récupération de l'orderService lié au companyService");
            System.out.println(companyServiceQuiVientDeSpring.getOrderService().getMaxOrderNumber());
            // System.out.println("Les orderServices sont-ils les mêmes ? : " + (orderServiceQuiVientDeSpring == companyServiceQuiVientDeSpring.getOrderService()));
            appContext.getBean(EmployeeService.class).sayHello();
        }

    }

}