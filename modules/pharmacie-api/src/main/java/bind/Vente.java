package bind;

public class Vente {
	private int idproduit,idassistant,idpharmacien,prix,quantite;
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdproduit() {
		return idproduit;
	}
	public void setIdproduit(int idproduit) {
		this.idproduit = idproduit;
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
	public int getprix() {
		return prix;
	}
	public void setprix(int prix) {
		this.prix = prix;
	}
	
}
