
package com.formateur.correctionformateur.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.formateur.correctionformateur.model.Plane;

public interface PlaneDao extends CrudRepository<Plane, Long> {

    public List<Plane> findByName(String name);

    public List<Plane> findByNameAndModelOrderByName(String name, String model);

}