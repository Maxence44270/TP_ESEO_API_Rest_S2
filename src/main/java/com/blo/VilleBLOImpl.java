package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville> getInfoVilles (String codePostal){
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		listVille = villeDAO.findVillesByPostCode(codePostal);
		return listVille;
	}
	
	public ArrayList<Ville> getAllVilles (){
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		listVille = villeDAO.findAllVilles();
		return listVille;
	}
	
	public Ville getVilleByName(String nomCommune) {
		return villeDAO.findVilleByName(nomCommune);
	}
	
	public Ville postVille (String nom) {
		return villeDAO.postVille(nom);
	}
	
	public void deleteVille (String nom) {
		villeDAO.deleteVille(nom);
	}
	

}
