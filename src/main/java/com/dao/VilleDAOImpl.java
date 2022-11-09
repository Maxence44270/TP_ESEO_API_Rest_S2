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
				//ville.setLigne(result.getString(""));
				ville.setNomCommune(result.getString("Nom_commune"));
				
				listVille.add(ville);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listVille;
	}

}
