package com.formateur.cours.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formateur.cours.core.configuration.SpringCoursConfiguration;
import com.formateur.cours.core.service.CompanyService;
import com.formateur.cours.core.service.EmployeeService;
import com.formateur.cours.core.service.OrderService;

public class SpringLauncherWithConfiguration {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
                SpringCoursConfiguration.class)) {

            CompanyService companyServiceQuiVientDeSpring = appContext.getBean(CompanyService.class);
            // CompanyService monBeanQuiVientDeSpring = new CompanyService();
            System.out.println("Nom de l'entreprise : " + companyServiceQuiVientDeSpring.getName());
            OrderService orderServiceQuiVientDeSpring = appContext.getBean(OrderService.class);
            System.out.println(orderServiceQuiVientDeSpring.getMaxOrderNumber());
            System.out.println("Récupération de l'orderService lié au companyService");
            System.out.println(companyServiceQuiVientDeSpring.getOrderService().getMaxOrderNumber());
            // System.out.println("Les orderServices sont-ils les mêmes ? : " +
            // (orderServiceQuiVientDeSpring ==
            // companyServiceQuiVientDeSpring.getOrderService()));
            appContext.getBean(EmployeeService.class).sayHello();

            System.out.println("La valeur maxCompanyId (qui vient du fichier de configuration ) vaut : "
                    + companyServiceQuiVientDeSpring.getMaxCompanyId());
        }

    }

}