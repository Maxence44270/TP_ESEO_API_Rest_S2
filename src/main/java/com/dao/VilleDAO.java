package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> findAllVilles();
	
	public ArrayList<Ville> findVillesByPostCode(String codePostal);
	
	public Ville findVilleByName(String nomCommune);
	
	public Ville postVille (String nom);
	
	public void deleteVille (String nom);

}
