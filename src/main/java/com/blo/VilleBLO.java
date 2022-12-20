package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVilles(String codePostal);
	
	public ArrayList<Ville> getAllVilles ();
	
	public Ville getVilleByName(String nomCommune);
	
	public Ville postVille(String nom);
	
	public void deleteVille(String nom);

}
