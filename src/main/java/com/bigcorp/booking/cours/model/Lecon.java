package com.bigcorp.booking.cours.model;

import java.util.HashSet;
import java.util.Set;

public class Lecon {
	
	private Long id;

	private String titre;
	
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

	
}
