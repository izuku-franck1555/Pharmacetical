package com.pharmacie.service;

import com.bd.Connection;
import com.pharmacie.model.Module;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModuleService {

	// VERIFIE SI UN MODULE APPARTIENT A UN ASSISTANT 
	public static boolean verifie(Integer idassistant, String idModule) throws SQLException {
		java.sql.Connection con = Connection.connect();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM module where idassistant = ?");
		stmt.setInt(1, idassistant);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			if(idModule.compareTo(result.getString(1).trim()) == 0) {
				return true;
			}
		}
		return false;
	}
	
	// RENVOIE LA LISTE DES MODULES D' UN PHARMACIEN
	public static List<Module> getPharmacienModuleList() throws SQLException {
		List<Module> list = new ArrayList<Module>();
		Module m = null;
		java.sql.Connection con = Connection.connect();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM modules_pharmacien");
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			m = new Module(result.getString(4), result.getString(2), result.getString(3));
			list.add(m);
		}
		return list;
	}
	
	// RENVOIE LA LISTE DES MODULES D' UN ASSISTANT A PARTIR DE SON ID 
	public static List<Module> getAssistantModuleList(Integer idassistant) throws SQLException {
		List<Module> list = new ArrayList<Module>();
		Module m = null;
		java.sql.Connection con = Connection.connect();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM module where idassistant = ?");
		stmt.setInt(1, idassistant);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			m = new Module(result.getString(4), result.getString(6), result.getString(8));
			list.add(m);
		}
		return list;
	}
}
