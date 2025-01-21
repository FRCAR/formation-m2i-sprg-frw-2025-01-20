package com.bigcorp.booking.correctionformateur;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.correctionformateur.configuration.SpringCorrectionConfiguration;
import com.bigcorp.booking.correctionformateur.service.BookingService;

@SpringBootApplication
public class SpringLauncherCorrectionWithConfiguration {

    public static void main(String[] args){

        //Exemple d'utilisation des jokers pour scanner de nombreux packages de base
        try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringCorrectionConfiguration.class)) {
            BookingService bookingService = appContext.getBean(BookingService.class);
            bookingService.getFlightService().sayHello();
        }
    }
}
