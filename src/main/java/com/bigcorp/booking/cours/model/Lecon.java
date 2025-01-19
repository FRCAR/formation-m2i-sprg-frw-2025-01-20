package com.bigcorp.booking.cours.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Lecon {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	private String titre;
	
	@OneToMany(mappedBy = "lecon")
	private Set<Example> examples = new HashSet<>();

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Example> getExamples() {
		return examples;
	}

	public void setExamples(Set<Example> examples) {
		this.examples = examples;
	}

	public void associateWith(Example example) {
		this.examples.add(example);
		example.setLecon(this);
	}
	
}
