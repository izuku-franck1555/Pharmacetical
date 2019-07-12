package com.pharmacie.model;

public class Pharmacien {

	int idpharmacien;
	String login;
	String passwd;
	String nom;
	String prenom;
	String contact;

	public Pharmacien(int idpharmacien, String login, String passwd, String nom, String prenom, String contact) {
		super();
		this.idpharmacien = idpharmacien;
		this.login = login;
		this.passwd = passwd;
		this.nom = nom;
		this.prenom = prenom;
		this.contact = contact;
	}
	public int getIdpharmacien() {
		return idpharmacien;
	}
	public void setIdpharmacien(int idpharmacien) {
		this.idpharmacien = idpharmacien;
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

	public void infosPharmacien() {
		System.out.println("Je suis un pharmacien qui a les informations suivantes : ");
		System.out.println("--------> Id Pharmacien : " + idpharmacien);
		System.out.println("--------> Nom           : " + nom);
		System.out.println("--------> Prenom        : " + prenom);
		System.out.println("--------> Contact       : " + passwd);
		System.out.println("--------> Login         : " + login);
		System.out.println("--------> Password      : " + passwd);
	}
}
