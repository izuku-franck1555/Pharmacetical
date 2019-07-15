package com.pharmacie.service;

import com.bd.Connection;
import com.pharmacie.model.Pharmacien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PharmacienService {

	// RENVOIE TRUE SI UN PHARMACIEN EXISTE, FALSE SINON !
	public static boolean existPharmacien(String login) throws SQLException {
		if (Connection.isConnect() == true) {
			java.sql.Connection con = Connection.connect();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM pharmacien where login = ?");
			stmt.setString(1, login);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				return true;
			}
			return false;
		} else {
			System.out.println("IMPOSSIBLE DE SE CONNECTER A LA BASE DE DONNEES !!!");
			return false;
		}
	}

	// RENVOIE L' ASSISTANT SI LES INFOS SONT CORRECTES, SINON NE RENVOIE RIEN.
	public static Pharmacien isPharmacien(String login, String password) throws SQLException {
		Pharmacien p;
		java.sql.Connection con = Connection.connect();
		if (existPharmacien(login)) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM pharmacien where login = ?");
			stmt.setString(1, login);
			ResultSet result = stmt.executeQuery();
			result.next();
			if (password.compareTo(result.getString(3)) == 0) {
				p = new Pharmacien(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
				return p;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	// RENVOIE UN PHARMACIEN A PARTIR DE SON ID
	public static Pharmacien getPharmacienWithId(int id) throws SQLException {
		Pharmacien p;
		java.sql.Connection con = Connection.connect();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM pharmacien where idpharmacien = ?");
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		result.next();
		p = new Pharmacien(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
		return p;
	}
}
