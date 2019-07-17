package bind;

public class ProduitBasic {
	
	private String nomProd;
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public int getQuantiteProd() {
		return quantiteProd;
	}
	public void setQuantiteProd(int quantiteProd) {
		this.quantiteProd = quantiteProd;
	}
	public int getPrixProd() {
		return prixProd;
	}
	public void setPrixProd(int prixProd) {
		this.prixProd = prixProd;
	}
	private int quantiteProd;
	private int prixProd;
	public ProduitBasic() {
		super();
		// TODO Auto-generated constructor stub
	}

}
