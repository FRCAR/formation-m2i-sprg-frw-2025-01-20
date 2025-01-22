package com.formateur.cours.springdatajpadao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.formateur.cours.model.Example;

@Repository
public interface ExampleDao extends CrudRepository<Example, Long> {

    public List<Example> findByNom(String nom);

    public List<Example> findByNomAndTaille(String nom, Float taille);

    @Query("select e from Example e where upper(e.nom) = upper(:param)")
    public List<Example> nomIdiot(@Param("param") String nom);

}
