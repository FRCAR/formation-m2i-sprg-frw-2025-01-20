package com.formateur.correctionformateur;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formateur.correctionformateur.configuration.SpringCorrectionConfiguration;
import com.formateur.correctionformateur.service.BookingService;

public class SpringLauncherCorrectionWithConfiguration {

    public static void main(String[] args){

        //Exemple d'utilisation des jokers pour scanner de nombreux packages de base
        try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringCorrectionConfiguration.class)) {
            BookingService bookingService = appContext.getBean(BookingService.class);
            bookingService.getFlightService().sayHello();
        }
    }
}
