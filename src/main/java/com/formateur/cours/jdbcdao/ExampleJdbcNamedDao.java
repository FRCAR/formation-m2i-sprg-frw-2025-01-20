package com.formateur.cours.jdbcdao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.formateur.cours.model.Example;

/**
 * DAO pour la classe Example.
 * Se base sur spring JdbcTemplate
 */
@Component
public class ExampleJdbcNamedDao {

    private NamedParameterJdbcTemplate jdbcTemplateObject;

    /**
     * La Datasource est nécessaire pour instancier l'unique
     * JdbcTemplate de ce DAO
     * 
     * @param dataSource
     */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * Supprime la table EXAMPLE si elle existe, puis la recréee.
     * Utilise getJdbcTemplate() pour récupérer un simple JdbcTemplate
     */
    public void dropAndCreateTable() {
        jdbcTemplateObject.getJdbcTemplate().execute("DROP TABLE IF EXISTS EXAMPLE");
        jdbcTemplateObject.getJdbcTemplate().execute("CREATE TABLE EXAMPLE(ID INTEGER PRIMARY KEY, NOM VARCHAR(255))");
        jdbcTemplateObject.getJdbcTemplate().execute("INSERT INTO EXAMPLE(ID , NOM ) VALUES (1, 'toto')");
    }

    /**
     * Renvoie tous les Example ayant nom comme nom en base de données.
     * Utilise une map d'objets paramétrés
     * 
     * @return
     */
    public List<Example> findByNom(String nom) {
        Map<String, Object> params = new HashMap<>();
        params.put("attributNom", nom);
        return jdbcTemplateObject.query(
                "SELECT * FROM EXAMPLE WHERE nom = :attributNom",
                params,
                new ExampleRowMapper());
    }

}
