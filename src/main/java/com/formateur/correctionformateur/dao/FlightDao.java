
package com.formateur.correctionformateur.dao;

import org.springframework.data.repository.CrudRepository;

import com.formateur.correctionformateur.model.Flight;

public interface FlightDao extends CrudRepository<Flight, Long> {

}