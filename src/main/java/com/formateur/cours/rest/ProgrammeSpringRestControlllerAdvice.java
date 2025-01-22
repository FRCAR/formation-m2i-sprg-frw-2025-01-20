package com.formateur.cours.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Un RestControllerAdvice offre des fonctionnalités 
 * transverses à tous les controleurs. On peut restreindre son champ d'application
 * en utilisant les attributs de l'annotation
 */
@RestControllerAdvice
public class ProgrammeSpringRestControlllerAdvice {

    /**
     * Une méthode annotée avec ExceptionHandler permet
     * de gérer les exceptions,et généralement de les transformer 
     * en réponses HTTP correctes.
     * @param e
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<String> gereLesExceptions(IllegalArgumentException e) {
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
        return response;
    }
}
