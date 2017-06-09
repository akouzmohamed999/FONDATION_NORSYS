package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Partenaire;
import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.services.PartenaireService;
import fr.norsys.fondation.services.ProjetService;

@RestController
public class ProjetController {

	@Autowired
	ProjetService projetService;

	@Autowired
	PartenaireService partenaireService;

	@RequestMapping(value = "/collaborateur/projets")
	public List<Projet> listeDesProjets() {
		return this.projetService.findAllProjets();
	}

	@RequestMapping(value = "/collaborateur/projet", method = RequestMethod.GET)
	public Projet projetParId(@RequestParam int idProjet) {
		return this.projetService.findProjetById(idProjet);
	}

	@RequestMapping(value = "/responsable/addProjet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Projet addProjet(@RequestBody Projet projet) {
		System.out.println("LE PROJET AJOUTE : " + projet);
		Projet storedProject = this.projetService.addProjet(projet);
		for (Partenaire partenaire : projet.getPartenaires()) {
			partenaire.getProjets().add(projet);
			this.partenaireService.updatePartenaire(partenaire);
		}
		return storedProject;
	}
}
