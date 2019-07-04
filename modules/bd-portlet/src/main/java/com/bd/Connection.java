package com.bd;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {
	private final static String url = "jdbc:postgresql://localhost:5432/test";
	private final static String url2 = "jdbc:mysql://localhost:3306/blog";
    private final static String user = "postgres";
    private final static String user2 = "root";
    private final static String password = "ammha";
    private final static String password2 = "";
 
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static java.sql.Connection connect() {
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
    
    public static java.sql.Connection connect2() {
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url2, user2, password2);
            System.out.println("Connected to the MYSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
 
    public static void ajout(String nom,String prenom) throws SQLException {
    	java.sql.Connection con = connect();
    	String query="INSERT INTO personne(nom,prenom) VALUES (?,?)";
    	PreparedStatement stmt = con.prepareStatement(query);    	
    	stmt.setString(1, nom);
    	stmt.setString(2, prenom);
    	try {
    		@SuppressWarnings("unused")
    		ResultSet rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	stmt.close();
    	con.close();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection.connect();
        Connection.connect2();
    }
}