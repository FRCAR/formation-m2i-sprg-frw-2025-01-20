package com.formateur.cours.conf;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.formateur.cours.rest.ControllerAuthorizationInterceptor;
import com.formateur.cours.rest.RestTemplateAuthorizationInterceptor;

//Configuration MVC : ajoute 
//des capacités à Spring Web
@Configuration
public class MaConfWeb implements WebMvcConfigurer {

    // AJoute des intercepteurs pour les contrôleurs :
    // ces intercepteurs vont agir avant et après chaque
    // requête HTTP traitée par ce serveur.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ControllerAuthorizationInterceptor());
    }

    // Crée un restTemplate avec son interceptor (qui ajoute des informations de sécurité)
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new RestTemplateAuthorizationInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
