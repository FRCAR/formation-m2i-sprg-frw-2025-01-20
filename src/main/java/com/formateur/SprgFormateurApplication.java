package com.formateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SprgFormateurApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SprgFormateurApplication.class, args);

        RestTemplate rt = applicationContext.getBean(RestTemplate.class);
        ResponseEntity<String> responseEntity = rt.getForEntity(
                "http://localhost:8080/rest/planes/1703", String.class);
        System.out.println("le body vaut : " + responseEntity.getBody());
        // test DAO
        // ExampleDao exampleDao = applicationContext.getBean(ExampleDao.class);
        // Example example = new Example();
        // example.setNom("nouvel exemple");
        // Example savedExample = exampleDao.save(example);
        // System.out.println("L'exemple sauvegardé vaut : " + savedExample);

        // exampleDao.findByNom("nouvel exemple").forEach(System.out::println);
        // System.out.println(applicationContext.getBean(PlaneRestController.class));
        // équivaut à :
        // for (Example exampleByNom : exampleDao.findByNom("nouvel exemple")) {
        // System.out.println(exampleByNom);
        // }

        //
        // //test service
        //
        // ExampleService exampleService =
        // applicationContext.getBean(ExampleService.class);
        // exampleService.delete(savedExample.getId());
        //
        // Example example2 = new Example();
        // example2.setNom("gnagna");
        // example2.setSeverite(Severite.PAS_GRAVE);
        // exampleService.save(example2);
        //
        // applicationContext.close();



    }
}
