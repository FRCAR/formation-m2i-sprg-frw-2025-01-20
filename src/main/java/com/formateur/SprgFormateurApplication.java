package com.formateur;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.formateur.cours.model.Example;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class SprgFormateurApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SprgFormateurApplication.class, args);

        // Création d'un RestTemplate et utilisation
        // pour envoyer une requête
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/examples/1";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        // Peut être simplifié en convertissant la ResponseEntity avec un DTO
        System.out.println("La réponse du webservice est : " + response.getBody());

        // Création d'un WebClient
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
                .build();

        // et utilisation pour envoyer une requête
        Mono<String> mono = client.get().uri("/rest/examples/1").retrieve().bodyToMono(String.class);
        System.out.println("Je vais envoyer une requête en asynchrone");
        mono.subscribe(s -> System.out.println("Réponse asynchrone " + s));

        // et utilisation pour envoyer deux requêtes chaînées en asynchrone
        System.out.println("\n\n Appel de mono pour récupérer une entité Example");
        client.get().uri("rest/examples/1").retrieve()
                .bodyToMono(Example.class)
                .flatMap(
                        e -> {
                            return client.get().uri("rest/examples-dtos/" + e.getId()).retrieve()
                                    .bodyToMono(Example.class);
                        })
                .subscribe(System.out::println);

        // Utilisation d'un restTEmplate venant du contexte Spring
        // avec son intercepteur (cf. classe MaConfWeb)
        System.out.println("On va utiliser le RestTemplate avec son intercepteur");
        RestTemplate rt = applicationContext.getBean(RestTemplate.class);
        ResponseEntity<String> responseEntity = rt.getForEntity(
                "http://localhost:8080/rest/examples/1", String.class);
        System.out.println("le body vaut : " + responseEntity.getBody());

        //
        // applicationContext.close();

    }
}
