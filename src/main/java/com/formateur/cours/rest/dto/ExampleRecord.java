package com.formateur.cours.rest.dto;

import jakarta.validation.constraints.Size;

/** Un DTO codé avec un record */
public record ExampleRecord(Long id,
        @Size(min = 4) String nom,
        Float taille) {

    public void afficheRecord() {
        System.out.println(this.id);
    }

}
