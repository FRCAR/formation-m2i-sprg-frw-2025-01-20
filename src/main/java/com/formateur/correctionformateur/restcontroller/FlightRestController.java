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

import com.formateur.correctionformateur.dto.FlightDto;
import com.formateur.correctionformateur.model.Flight;
import com.formateur.correctionformateur.service.FlightService;

@RestController
public class FlightRestController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/rest/flights/{id}")
    public Optional<FlightDto> findById(@PathVariable("id") Long id) {
        Optional<Flight> optionalFlight = this.flightService.findById(id);
        if(optionalFlight.isEmpty()){
            return Optional.empty();
        }
        //else ...
        Flight flight = optionalFlight.get();
        return Optional.of(new FlightDto(flight.getId(), flight.getFrom(), flight.getTo()));
    }

    @PostMapping("/rest/flights")
    public Flight save(@RequestBody @Validated FlightDto flight) {
        return this.flightService.save(flight.toFlight());
    }

    @DeleteMapping("/rest/flights/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.flightService.deleteById(id);
        ;
    }

}
