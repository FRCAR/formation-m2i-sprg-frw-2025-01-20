package com.formateur.correctionformateur.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formateur.correctionformateur.dao.FlightDao;
import com.formateur.correctionformateur.model.Flight;

@Service
public class FlightService {

    @Autowired
    private FlightDao flightDao;

    public void sayHello() {
        System.out.println("Salut de FlightService !!");
    }

    public Optional<Flight> findById(Long id) {
        return this.flightDao.findById(id);
    }

    @Transactional
    public Flight save(Flight flight) {
        return this.flightDao.save(flight);
    }

    @Transactional
    public void deleteById(Long id) {
        this.flightDao.deleteById(id);
    }
}
