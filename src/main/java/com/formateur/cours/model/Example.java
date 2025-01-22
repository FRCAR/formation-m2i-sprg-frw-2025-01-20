package com.formateur.cours.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nom;

    private Float taille;

    @Enumerated(EnumType.STRING)
    private Severite severite;

    @ManyToOne
    @JoinColumn(name = "LECON_ID")
    private Lecon lecon;

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

    public Severite getSeverite() {
        return severite;
    }

    public void setSeverite(Severite severite) {
        this.severite = severite;
    }

    public Lecon getLecon() {
        return lecon;
    }

    public void setLecon(Lecon lecon) {
        this.lecon = lecon;
    }

    @Override
    public String toString() {
        return "Example [id=" + id + ", nom=" + nom + "]";
    }

}
