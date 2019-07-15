package com.pharmacie.model;

public class Module {
	
	String idmodule;
	String idassistant; 
	String idpharmacien; 
	String nom; 
	String fonctionnalites;
	String chemin;
	String description; 
	String nom_image;
	
	public String getIdmodule() {
		return idmodule;
	}
	public void setIdmodule(String idmodule) {
		this.idmodule = idmodule;
	}
	public String getIdassistant() {
		return idassistant;
	}
	public void setIdassistant(String idassistant) {
		this.idassistant = idassistant;
	}
	public String getIdpharmacien() {
		return idpharmacien;
	}
	public void setIdpharmacien(String idpharmacien) {
		this.idpharmacien = idpharmacien;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getFonctionnalites() {
		return fonctionnalites;
	}
	public void setFonctionnalites(String fonctionnalites) {
		this.fonctionnalites = fonctionnalites;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom_image() {
		return nom_image;
	}
	public void setNom_image(String nom_image) {
		this.nom_image = nom_image;
	}
	
	public Module(String nom, String chemin, String nom_image) {
		super();
		this.nom = nom;
		this.chemin = chemin;
		this.nom_image = nom_image;
	} 
}
