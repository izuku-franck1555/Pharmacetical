package com.pharmacie.model;

public class Assistant {

	int idassistant;
	int idpharmacien;
	String nom;
	String prenom;
	String contact;
	String login;
	String passwd;

	public Assistant(int idassistant, int idpharmacien, String nom, String prenom, String contact, String login,
			String passwd) {
		super();
		this.idassistant = idassistant;
		this.idpharmacien = idpharmacien;
		this.nom = nom;
		this.prenom = prenom;
		this.contact = contact;
		this.login = login;
		this.passwd = passwd;
	}

	public int getIdassistant() {
		return idassistant;
	}
	public void setIdassistant(int idassistant) {
		this.idassistant = idassistant;
	}
	public int getIdpharmacien() {
		return idpharmacien;
	}
	public void setIdpharmacien(int idpharmacien) {
		this.idpharmacien = idpharmacien;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void infosAssistant() {
		System.out.println("Je suis un assistant qui a les informations suivantes : ");
		System.out.println("--------> Id Assistant  : " + idassistant);
		System.out.println("--------> Id Pharmacien : " + idpharmacien);
		System.out.println("--------> Nom           : " + nom);
		System.out.println("--------> Prenom        : " + prenom);
		System.out.println("--------> Contact       : " + passwd);
		System.out.println("--------> Login         : " + login);
		System.out.println("--------> Password      : " + passwd);
	}
}
