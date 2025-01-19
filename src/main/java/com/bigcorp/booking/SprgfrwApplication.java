package com.bigcorp.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprgfrwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprgfrwApplication.class, args);
		
		//test DAO
//		ExampleDao exampleDao = applicationContext.getBean(ExampleDao.class);
//		Example example = new Example();
//		example.setNom("nouvel exemple");
//		Example savedExample = exampleDao.save(example);
//		System.out.println("L'exemple sauvegardé vaut : " + savedExample);
//		
//		//test service
//
//		ExampleService exampleService = applicationContext.getBean(ExampleService.class);
//		exampleService.delete(savedExample.getId());
//		
//		Example example2 = new Example();
//		example2.setNom("gnagna");
//		example2.setSeverite(Severite.PAS_GRAVE);
//		exampleService.save(example2);
//		
//		applicationContext.close();
	}

}
