package com.formateur.cours.springdatajpadao;

import org.springframework.data.repository.CrudRepository;

import com.formateur.cours.model.Lecon;

public interface LeconDao extends CrudRepository<Lecon, Long>{
    
}
