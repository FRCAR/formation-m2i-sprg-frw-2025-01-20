package com.bigcorp.booking.correctionformateur;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.correctionformateur.service.BookingService;

@SpringBootApplication
public class SpringLauncherCorrectionWithConfiguration {

    public static void main(String[] args){

        try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext("com.bigcorp.**.service")) {
            BookingService bookingService = appContext.getBean(BookingService.class);
            bookingService.getFlightService().sayHello();
        }
    }
}
