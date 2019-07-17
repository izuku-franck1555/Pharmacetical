package model;

public class Produit {
	private String nom="", description="",datePeremption="";
	private int quantite=0;
	private double prixPublique=0, prixUnitaire=0;
	
	public Produit(){
		super();
	}
	
	public Produit(Produit x){
		nom=x.getNom();
		description=x.getDescription();
		datePeremption=x.getDatePeremption();
		quantite=x.getQuantite();
		prixPublique=x.getPrixPublique();
		prixUnitaire=x.getPrixUnitaire();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrixPublique() {
		return prixPublique;
	}
	public void setPrixPublique(double prixPublique) {
		this.prixPublique = prixPublique;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getDatePeremption() {
		return datePeremption;
	}
	public void setDatePeremption(String datePeremption) {
		this.datePeremption = datePeremption;
	}
	
	public void affiche() {
		System.out.println(nom);
		System.out.println(description);
		System.out.println(quantite);
		System.out.println(prixUnitaire);
		System.out.println(prixPublique);
		System.out.println(datePeremption);
	}
}
