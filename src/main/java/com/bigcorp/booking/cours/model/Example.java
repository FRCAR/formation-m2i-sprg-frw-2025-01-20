package com.bigcorp.booking.cours.model;

public class Example  {

	private Long id;
	
	private String nom;
	
	private Float taille;
	
	private Severite severite;
	
	private Lecon lecon;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getTaille() {
		return taille;
	}

	public void setTaille(Float taille) {
		this.taille = taille;
	}

	public Severite getSeverite() {
		return severite;
	}

	public void setSeverite(Severite severite) {
		this.severite = severite;
	}

	public Lecon getLecon() {
		return lecon;
	}

	public void setLecon(Lecon lecon) {
		this.lecon = lecon;
	}

	public void associateWith(Lecon lecon) {
		this.lecon = lecon;
		lecon.getExamples().add(this);
	}

	@Override
	public String toString() {
		return "Example [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
