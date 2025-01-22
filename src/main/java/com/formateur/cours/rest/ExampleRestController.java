package com.formateur.cours.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formateur.cours.core.service.ExampleService;
import com.formateur.cours.model.Example;
import com.formateur.cours.rest.dto.ExampleRecord;

/**
 * RestController : contient les méthodes
 * pour traiter des requêtes HTTP REST
 */
@RestController
public class ExampleRestController {

    @Autowired
    private ExampleService exampleService;

    /**
     * Répond aux requêtes GET sur /rest/examples/{id}
     * Renvoie un Optional qui contient un POJO: Spring Web le transformera en JSON
     * @param id
     * @return
     */
    @GetMapping("/rest/examples/{id}")
    public Optional<Example> findById(@PathVariable("id") Long id) {
        System.out.println("L'id passé dans la requête est : " + id);
        return this.exampleService.findById(id);
    }

    /**
     * Répond aux requêtes GET sur /rest/examples/{id}
     * Renvoie un Optional qui contient un record : Spring Web le transformera en JSON
     * @param id
     * @return
     */
    @GetMapping("/rest/examples-dtos/{id}")
    public Optional<ExampleRecord> findDtoById(@PathVariable("id") Long id) {
        System.out.println("L'id passé dans la requête est : " + id);
        Optional<Example> example = this.exampleService.findById(id);
        Example realExample = example.orElse(new Example());
        ExampleRecord exampleRecord = new ExampleRecord(realExample.getId(), realExample.getNom(),
                realExample.getTaille());
        return Optional.of(exampleRecord);
    }

    /**
     * Répond aux requêtes POST sur /rest/examples-dtos.
     * Le corps de la requête(JSON) est transformé en ExampleRecord par Spring Web
     * @param example
     * @return
     */
    @PostMapping("/rest/examples-dtos")
    public ExampleRecord save(@RequestBody @Validated ExampleRecord example) {
        System.out.println("On va sauvegarder l'exemple : " + example);
        return example;
    }

    /**
     * Répond aux requêtes POST sur /rest/examples.
     * Le corps de la requête(JSON) est transformé en Example par Spring Web
     * @param example
     * @return
     */
    @PostMapping("/rest/examples")
    public Example save(@RequestBody @Validated Example example) {
        System.out.println("On va sauvegarder l'exemple : " + example);
        return this.exampleService.save(example);
    }

    /**
     * Répond aux requêtes PUT sur /rest/examples/{id}
     * Le corps de la requête(JSON) est transformé en Example par Spring Web
     * @param id
     * @param example
     * @return
     */
    @PutMapping("/rest/examples/{id}")
    public ResponseEntity<Example> save(@PathVariable("id") Long id, @RequestBody Example example) {
        System.out.println("On va sauvegarder l'exemple : " + example);
        ResponseEntity<Example> response = ResponseEntity
                .status(HttpStatus.OK)
                .header("X-Max-Lifetime", "44")
                .header("X-super-id", "Mon id")
                .body(example);
        return response;
    }


}
