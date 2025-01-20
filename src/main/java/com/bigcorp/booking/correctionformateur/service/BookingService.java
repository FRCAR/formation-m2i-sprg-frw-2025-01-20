package com.bigcorp.booking.correctionformateur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    
    @Autowired
    private FlightService flightService;

    public FlightService getFlightService() {
        return flightService;
    }

    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

}
