package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.services.ProjetService;

@RestController
public class ProjetController {

	@Autowired
	ProjetService projetService;

	@RequestMapping(value = "/administrateur/")
	public List<Projet> listeDesProjets() {
		return this.projetService.findAllProjets();
	}

	@RequestMapping(value = "/administrateur/projet", method = RequestMethod.GET)
	public Projet projetParId(@RequestParam int idProjet) {
		return this.projetService.findProjetById(idProjet);
	}
}
