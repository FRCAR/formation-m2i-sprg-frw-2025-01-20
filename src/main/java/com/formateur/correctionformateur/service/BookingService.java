package com.formateur.correctionformateur.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formateur.correctionformateur.dao.BookingDao;
import com.formateur.correctionformateur.model.Booking;

import jakarta.transaction.Transactional;

@Service
public class BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private FlightService flightService;

    public FlightService getFlightService() {
        return flightService;
    }

    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    public Optional<Booking> findById(Long id) {
        return this.bookingDao.findById(id);
    }

    @Transactional
    public Booking save(Booking booking) {
        return this.bookingDao.save(booking);
    }

    @Transactional
    public void deleteById(Long id) {
        this.bookingDao.deleteById(id);
    }

}
