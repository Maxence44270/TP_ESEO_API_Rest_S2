package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeBLOService;
	
	//fonction pour récupérer les villes ayant un même code postal
	
	@RequestMapping(value = "/ville", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> get(@RequestParam(required = false, value="codePostal") String codePostal){
		System.out.println("get");
		//codePostal = "01260";
		ArrayList<Ville> listeVille = villeBLOService.getInfoVilles(codePostal);
		
		return listeVille;
	}
	
	//fonction pour récupérer tout le contenu de la BDD (nom de commune et code postal uniquement)
	
	@RequestMapping(value = "/villes", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> getAll(){
		System.out.println("get");
		
		ArrayList<Ville> listeVille = villeBLOService.getAllVilles();
		
		return listeVille;
	}
	
	//fonction pour envoyer puis afficher une ville dans la base de données 
	
	@RequestMapping(value = "/postville", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Ville post () {
		System.out.println("Post");
		
		Ville ville = villeBLOService.postVille("Machecoul");
		
		return ville;
	}
	
	//fonction pour supprimer la ville qu'on a ajoutée
	
	@RequestMapping(value = "/deleteville", method = {RequestMethod.DELETE, RequestMethod.GET})
	@ResponseBody
	public String delete() {
		
		villeBLOService.deleteVille("Machecoul");
		
		return "Well deleted";
	}
	

}
