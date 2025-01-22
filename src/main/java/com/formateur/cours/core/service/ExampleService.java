package com.formateur.cours.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formateur.cours.model.Example;
import com.formateur.cours.springdatajpadao.ExampleDao;

@Service
public class ExampleService {

    @Autowired
    private ExampleDao exampleDao;

    public Example save(Example example){
        if(example.getTaille() != null && example.getTaille() < 0){
            throw new IllegalArgumentException("Impossible de sauvegarder un exemple avec une taille négative");
        }
        return this.exampleDao.save(example);
    }

    public Optional<Example> findById(Long id){
        return this.exampleDao.findById(id);
    }

}
