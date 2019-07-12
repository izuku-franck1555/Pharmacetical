package com.bd;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	private final static String url = "jdbc:postgresql://localhost:5432/pharmacie";
    private final static String user = "postgres";
    private final static String password = "ammha";

    public static boolean isConnect() {
        @SuppressWarnings("unused")
		java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static java.sql.Connection connect() {
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
 
    public static void main(String[] args) throws SQLException {
        Connection.connect();
    }
}