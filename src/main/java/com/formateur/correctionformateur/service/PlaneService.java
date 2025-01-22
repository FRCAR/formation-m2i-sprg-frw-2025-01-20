package com.formateur.correctionformateur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formateur.correctionformateur.dao.PlaneDao;
import com.formateur.correctionformateur.model.Plane;

@Service
public class PlaneService {

    @Autowired
    private PlaneDao planeDao;

    public Optional<Plane> findById(Long id) {
        return this.planeDao.findById(id);
    }

    @Transactional
    public Plane save(Plane plane) {
        return this.planeDao.save(plane);
    }

    @Transactional
    public void deleteById(Long id) {
        this.planeDao.deleteById(id);
    }

    public List<Plane> findByName(String name){
        return this.planeDao.findByName(name);
    }

    public List<Plane> findByNameAndModelOrderByName(String name, String model){
        return this.planeDao.findByNameAndModelOrderByName(name, model);
    }

    public Iterable<Plane> findAll() {
        return this.planeDao.findAll();
    }
}
