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

import com.formateur.correctionformateur.model.Plane;
import com.formateur.correctionformateur.service.PlaneService;

@RestController
public class PlaneRestController {

    @Autowired
    private PlaneService planeService;

    @GetMapping("/rest/planes/{id}")
    public Optional<Plane> findById(@PathVariable("id") Long id) {
        return this.planeService.findById(id);
    }

    @PostMapping("/rest/planes")
    public Plane save(@RequestBody @Validated Plane plane) {
        return this.planeService.save(plane);
    }

    @DeleteMapping("/rest/planes/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.planeService.deleteById(id);
    }

}
