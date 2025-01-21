package com.bigcorp.booking.cours.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nom;

    private Float taille;

    // private Severite severite;

    // private Lecon lecon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getTaille() {
        return taille;
    }

    public void setTaille(Float taille) {
        this.taille = taille;
    }

    @Override
    public String toString() {
        return "Example [id=" + id + ", nom=" + nom + "]";
    }

}
