
package com.formateur.correctionformateur.dao;

import org.springframework.data.repository.CrudRepository;

import com.formateur.correctionformateur.model.Booking;

public interface BookingDao extends CrudRepository<Booking, Long> {

}