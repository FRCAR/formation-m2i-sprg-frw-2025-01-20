package com.formateur.cours.rest;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Cet intercepteur affiche l'entête Authorization
 */
public class ControllerAuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Je vais traiter le requête : " + request.getRequestURL());
        System.out.println("L'entete Authorization vaut : " + request.getHeader("Authorization"));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("J'ai traité la requête : le statut vaut :  " + response.getStatus());
    }

}
