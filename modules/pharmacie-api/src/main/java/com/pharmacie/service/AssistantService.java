package com.pharmacie.service;

import com.bd.Connection;
import com.pharmacie.model.Assistant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssistantService {

	// RENVOIE TRUE SI UN ASSISTANT EXISTE, FALSE SINON !
	public static boolean existAssistant(String login) throws SQLException {
		if (Connection.isConnect() == true) {
			java.sql.Connection con = Connection.connect();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM assistant where login = ?");
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
	public static Assistant isAssistant(String login, String password) throws SQLException {
		Assistant a;
		java.sql.Connection con = Connection.connect();
		if (existAssistant(login)) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM assistant where login = ?");
			stmt.setString(1, login);
			ResultSet result = stmt.executeQuery();
			result.next();
			if (password.compareTo(result.getString(7)) == 0) {
				a = new Assistant(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
				return a;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
