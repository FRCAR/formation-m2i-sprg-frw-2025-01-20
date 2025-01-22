package com.formateur.cours.rest;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Intercepteur de RestTemplate: implémente ClientHttpRequestInterceptor pour agir
 * avant ou après l'envoi d'une requête.
 */
public class RestTemplateAuthorizationInterceptor
        implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request,
            byte[] body,
            ClientHttpRequestExecution execution) throws IOException {
        
        request.getHeaders().add("Authorization", "mon-token");
        ClientHttpResponse response = execution.execute(request, body);
        response.getHeaders().add("Control", "Value");
        return response;
    }
}
