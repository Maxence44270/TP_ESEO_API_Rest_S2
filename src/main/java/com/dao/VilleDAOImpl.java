package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	public ArrayList<Ville> findAllVilles() {
		System.out.println("findAllVilles");
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		String url="jdbc:mysql://localhost:3306/maven";
		String username="root";
		String password="network";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("Select * from ville_france");
			
			while (result.next()) {
				Ville ville = new Ville();
				ville.setCodePostal(result.getString("Code_postal"));
				ville.setNomCommune(result.getString("Nom_commune"));
				ville.setLatitude(result.getString("Latitude"));
				ville.setLongitude(result.getString("Longitude"));
				
				listVille.add(ville);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listVille;
	}
	
	public ArrayList<Ville> findVillesByPostCode(String codePostal) {
		System.out.println("find Ville by postcode : " + codePostal);
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		String url="jdbc:mysql://localhost:3306/maven";
		String username="root";
		String password="network";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("Select * from ville_france WHERE Code_postal = " + codePostal);
			
			while (result.next()) {
				Ville ville = new Ville();
				ville.setCodePostal(result.getString("Code_postal"));
				ville.setNomCommune(result.getString("Nom_commune"));
				ville.setLatitude(result.getString("Latitude"));
				ville.setLongitude(result.getString("Longitude"));
				
				listVille.add(ville);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listVille;
	}
	
	public Ville findVilleByName(String nomCommune) {
		Ville ville = new Ville();
		
		System.out.println("find Ville by nomCommune : " + nomCommune);
		
		String url="jdbc:mysql://localhost:3306/maven";
		String username="root";
		String password="network";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("Select * from ville_france WHERE Nom_commune LIKE '" + nomCommune + "'");
			
			while (result.next()) {
				ville.setCodePostal(result.getString("Code_postal"));
				ville.setNomCommune(result.getString("Nom_commune"));
				ville.setLatitude(result.getString("Latitude"));
				ville.setLongitude(result.getString("Longitude"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ville;
	}
	
	public Ville postVille (String nom) {
		String url="jdbc:mysql://localhost:3306/maven";
		String username="root";
		String password="network";
		
		Ville ville = new Ville();
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement();
			ville.setCodePostal("44270");
			ville.setNomCommune(nom);
			
			System.out.println("INSERT INTO ville_france VALUES('99999', '" + ville.getNomCommune() + "',"
					+ " '" + ville.getCodePostal() + "', '"+ ville.getNomCommune() + "', '', '', '')");
			
			int result = statement.executeUpdate("INSERT INTO ville_france VALUES('99999', '" + ville.getNomCommune() + "',"
					+ " '" + ville.getCodePostal() + "', '"+ ville.getNomCommune() + "', '', '', '')");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ville;

	}
	
	public void deleteVille (String nom) {
		String url="jdbc:mysql://localhost:3306/maven";
		String username="root";
		String password="network";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement();
			System.out.println("DELETE * FROM ville_france WHERE Nom_commune = '"+ nom+ "'");
			int result = statement.executeUpdate("DELETE FROM ville_france WHERE Nom_commune = '"+ nom+ "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
