package com.formateur.cours.jdbcdao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formateur.cours.model.Example;

public class SpringJdbcDaoLauncher {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
                SpringJdbcConfiguration.class)) {

            ExampleJdbcNamedDao dao = appContext.getBean(ExampleJdbcNamedDao.class);
            dao.dropAndCreateTable();
            List<Example> examples = dao.findByNom("toto");
            System.out.println("Affichage des exemples");
            for (Example example : examples) {
                System.out.println(example);
            }
        }
    }
}
