package model;

import java.sql.*;
import java.util.ArrayList;

import bind.Cellule;
import bind.Vente;
import bind.Vrai_Vente;

public class ConnectDB {
	private Connection con;
	
	String user="postgres",url="jdbc:postgresql://192.168.43.29:5432/postgres", passwd="adess";
	
	//connection a la base de donn�e
	public Connection createConnection(){
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,user,passwd);
			//System.out.println("connection ok");
		}catch(SQLException e) {
			System.out.println("erreur");
		}catch (ClassNotFoundException e) {
			System.out.println("class : org.postgresql.Driver NOT FOUND");
		}
		return con;
	}
	
	
	// verifier l'existance d'un produit dan la	 base de donn�e !!!!!!!!!!!!
	public int existe(Produit p) throws SQLException {
		createConnection();
		int idProduit=-1;
		String query = "select * from produit";
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet result = stm.executeQuery(); 
		while(result.next() && idProduit==-1) {
			if( result.getString("nom").equals(p.getNom())){
				idProduit = result.getInt("idproduit");
			}
		}
		return idProduit;
	}
	

	// verifier l'existance d'un produit dan la	 base de donn�e par son nom !!!!!!!!!!!!
	
	public int existe2(String p) throws SQLException {
		createConnection();
		int idProduit=-1;
		String query = "select * from produit";
		System.out.print("con est null:");
		System.out.println(con==null);
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet result = stm.executeQuery(); 
		while(result.next() && idProduit==-1) {
			if( result.getString("nom").equals(p)){
				idProduit = result.getInt("idproduit");
			}
		}
		return idProduit;
	}
	
	
	//recherche de la cellule correspondand au dernier ajout d'un produit
	

	
	//recherche de l'identifiant le plus grand d'une vente !!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	public int recherche_plusGrand_id_vente() throws SQLException {
		createConnection();
		int compt=0;
		String query = "select * from vente";
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet result = stm.executeQuery(); 
		while(result.next()) {
			if( result.getInt("idvente")>compt){
				compt = result.getInt("idvente");
			}
		}
		System.out.println("trouv�");
		return compt;
	}
	
	//insertion dans vente sans identifiant!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	public boolean insert_sans_id_vente(Vente p) throws SQLException {
		createConnection();
		boolean test = false;
		String query1 = "insert into vente(idproduit,idassistant,idpharmacien,prix,datevente,quantite) values(?,?,?,?,now(),?)";
		
			PreparedStatement stm = con.prepareStatement(query1);

			stm.setInt(1, p.getIdproduit());
			stm.setInt(2, p.getIdassistant());
			stm.setInt(3, p.getIdpharmacien());
			stm.setInt(4, p.getprix());
			stm.setInt(5, p.getQuantite());
			int i = stm.executeUpdate();
			if (i>0)test=true;
		return test ;//&& diminuerProduit(p.getprix(),p.getQuantite());
	}	//insertion dans vente sans identifiant!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	public boolean insert_vente(Vrai_Vente p) throws SQLException {
		createConnection();
		boolean test = false;
		String query1 = "insert into vente(idproduit,idassistant,idpharmacien,prix,datevente,idvente,quantite) values(?,?,?,?,now(),?,?)";
		
			PreparedStatement stm = con.prepareStatement(query1);

			stm.setInt(1, p.getIdproduit());
			stm.setInt(2, p.getIdassistant());
			stm.setInt(3, p.getIdpharmacien());
			stm.setInt(4, p.getprix());
			stm.setInt(5, p.getIdVente());
			stm.setInt(6, p.getQuantite());
			int i = stm.executeUpdate();
			if (i>0)test=true;
		return test ;//&& diminuerProduit(p.getprix(),p.getQuantite());
	}
	
	//recuperation des propriete d'une cellule
	
	public Produit getProduit(int id) throws SQLException {
		createConnection();
		Produit resultat=new Produit();
		String query = "select * from cellule where numcellule=?";
		PreparedStatement stm = con.prepareStatement(query);
		stm.setInt(1, id);
		ResultSet result = stm.executeQuery();
		while (result.next()) {
			resultat.setNom(result.getString("nom"));
			resultat.setDescription(result.getString("description"));
			resultat.setQuantite(Integer.valueOf(result.getString("quantite")));
			resultat.setPrixPublique(Double.valueOf(result.getString("prixpublique")));
			resultat.setPrixUnitaire(Double.valueOf(result.getString("prixunitaire")));
			resultat.setDatePeremption(result.getString("datedeperemption"));
		}
		return resultat;
	}
	
	
	// recuperation de la position d'un produit a partir de son identifiant
	
	public Cellule getCellule(int id) throws SQLException {
		createConnection();
		Cellule resultat=new Cellule();
		String query = "select * from cellule where idproduit=?";
		PreparedStatement stm = con.prepareStatement(query);
		stm.setInt(1, id);
		ResultSet result = stm.executeQuery();
		while (result.next()) {
			resultat.setIdproduit(result.getInt("idproduit"));
			resultat.setNumcellule(result.getInt("numcellule"));
			resultat.setNumetagere(result.getInt("numetagere"));
			resultat.setNumrayon(result.getInt("numrayon"));
		}
		return resultat;
	}
	
	//recuperation de la quantit� d'un produit

	public int getPrix(int id) throws SQLException {
		createConnection();
		String query = "select * from produit where idproduit=?";
		PreparedStatement stm = con.prepareStatement(query);
		stm.setInt(1, id);
		ResultSet result = stm.executeQuery();
		int resultat = 0;
		while (result.next()) resultat  = result.getInt("prixunitaire");
		return resultat;
	}
	
	
	//recuperation du prix
	
	public int getQuantite(int id) throws SQLException {
		createConnection();
		String query = "select * from produit where idproduit=?";
		PreparedStatement stm = con.prepareStatement(query);
		stm.setInt(1, id);
		ResultSet result = stm.executeQuery();
		int resultat = 0;
		while (result.next()) resultat  = result.getInt("quantite");
		return resultat;
	}
	
	//ajout d'un produits dans la base de donn�e !!!!!!!!!!!!!
	
	public boolean addProduit(Produit p) throws SQLException {
		boolean test = false;
		int idProduit = existe(p);
		String query1 = "insert into produit(nom,description,quantite,prixpublique,prixunitaire,datedeperemption) values(?,?,?,?,?,?)";
		String query2 = "update produit set quantite = ? where idproduit=?";
		if(idProduit == -1) {
			PreparedStatement stm = con.prepareStatement(query1);
			stm.setString(1, p.getNom());
			stm.setString(2, p.getDescription());
			stm.setInt(3, p.getQuantite());
			stm.setDouble(4, p.getPrixPublique());
			stm.setDouble(5, p.getPrixUnitaire());
			stm.setString(6, p.getDatePeremption().toString());
			int i = stm.executeUpdate();
			if (i>0)test=true;
		}
		else {
			PreparedStatement stm = con.prepareStatement(query2);
			stm.setInt(1, getQuantite(idProduit)+p.getQuantite());
			stm.setInt(2, idProduit);
			stm.executeUpdate();
			test=true;
		}
		return test;
	}
	
	
	// diminuer produit de la base de donn�e 
	
	public boolean diminuerProduit(int idProduit,int quantite) throws SQLException {
		boolean test = false;
		createConnection();
		//String query1 = "insert into produit(nom,description,quantite,prixpublique,prixunitaire,datedeperemption) values(?,?,?,?,?,?)";
		String query2 = "update produit set quantite = ? where idproduit=?"; 
		if(idProduit == -1) {
			System.out.println("le produit n'existe pas");
			test=true;
		}
		else {
			int prod=getQuantite(idProduit);
			if(prod>=quantite) {
				PreparedStatement stm = con.prepareStatement(query2);
				stm.setInt(1, prod-quantite);
				stm.setInt(2, idProduit);
				stm.executeUpdate();
				System.out.println("produit retirer de la bd");
				test=true;
			}
			else {
				System.out.println("il ne manque plus que:"+getQuantite(idProduit)+"au lieu de :"+quantite);
			}
			
		}
		return test;
	}	
	
	// mise a jours du produit dans la base de donn�e
	
	public boolean updateProduit(Produit p) throws SQLException {
		boolean test = false;
		createConnection();
		int idProduit = existe(p);
		String query = "update produit set nom=?, description=?, quantite = ?, prixpublique=?, prixunitaire=?, "
				+ "datedeperemption=? where idproduit=?"; 
		if(idProduit != -1) {
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, p.getNom());
			stm.setString(2, p.getDescription());
			stm.setInt(3, p.getQuantite());
			stm.setDouble(4, p.getPrixPublique());
			stm.setDouble(5, p.getPrixUnitaire());
			stm.setString(6, p.getDatePeremption().toString());
			stm.setInt(7, idProduit);
			int i = stm.executeUpdate();
			if (i>0)test=true;
		}
		return test;
	}
	
	public static void main(String [] args) throws SQLException {
		ConnectDB con = new ConnectDB();
//		ResultSet res = con.getVenteJour("2019/07/17");
		ResultSet res = con.getVenteMoisDernier();
		while(res.next()) {
			System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6)+" "+res.getString(7));
		}
	}

	public ResultSet getListe() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet result;
		createConnection();
		String query = "select * from produit";
		PreparedStatement stm = con.prepareStatement(query);
		result = stm.executeQuery();
		return result;
	}
	
	/*public ResultSet getVenteJour(String date) throws SQLException {
		createConnection();
		String query = "select * from vente where datevente = date '"+date+"'";
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet res = stm.executeQuery();
		return res;
	}
	
	public ResultSet getVenteAnneDerniere() throws SQLException {
		createConnection();
		String query = "select * from vente where date_part('year', datevente) = date_part('year', now()) - 1";
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet res = stm.executeQuery();
		return res;
	}
	
	public ResultSet getVenteMoisDernier() throws SQLException {
		createConnection();
		String query = "select * from vente where date_part('month', datevente) = date_part('month', now()) - 1";
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet res = stm.executeQuery();
		return res;
	}*/
/*partie tre importante pour liferay*/
	public ResultSet getVenteJour(String date) throws SQLException {
		createConnection();
		String query = "select * from vente where datevente = "+date;
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet res = stm.executeQuery();
		return res;
	}
	
	public ResultSet getVenteAnneDerniere() throws SQLException {
		createConnection();
		String query = "select * from vente where date_part('year', date datevente) = date_part('year', now()) - 1";
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet res = stm.executeQuery();
		return res;
	}
	
	public ResultSet getVenteMoisDernier() throws SQLException {
		createConnection();
		String query = "select * from vente where date_part('month', date datevente) = date_part('month', now()) - 1";
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet res = stm.executeQuery();
		return res;
	}

	public ResultSet getFour() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet result;
		createConnection();
		String query = "select * from fournisseur";
		PreparedStatement stm = con.prepareStatement(query);
		result = stm.executeQuery();
		return result;
	}
}
