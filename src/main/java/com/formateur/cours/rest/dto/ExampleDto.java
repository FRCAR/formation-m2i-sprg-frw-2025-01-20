package com.formateur.cours.rest.dto;


/** 
 * un DTO (Data Transfer Object)
 * codé "à la main"
 */
public class ExampleDto {

    private Long id;

    private String nom;

    private Float taille;

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

}
