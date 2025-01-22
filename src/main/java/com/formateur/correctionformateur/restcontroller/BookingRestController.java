package com.formateur.correctionformateur.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formateur.correctionformateur.model.Booking;
import com.formateur.correctionformateur.service.BookingService;

@RestController
public class BookingRestController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/rest/bookings/{id}")
    public Optional<Booking> findById(@PathVariable("id") Long id) {
        return this.bookingService.findById(id);
    }

    @PostMapping("/rest/bookings")
    public Booking save(@RequestBody @Validated Booking booking) {
        return this.bookingService.save(booking);
    }

    @DeleteMapping("/rest/bookings/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.bookingService.deleteById(id);
        ;
    }

}
