package com.formateur.correctionformateur.dto;

import com.formateur.correctionformateur.model.Flight;

import jakarta.validation.constraints.NotEmpty;

public record FlightDto(Long id, @NotEmpty String from, @NotEmpty String to) {

    public Flight toFlight() {
        Flight flight = new Flight();
        flight.setId(this.id);
        flight.setFrom(this.from);
        flight.setTo(this.to);
        return flight;
    }

}
