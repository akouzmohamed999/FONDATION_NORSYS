package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.services.CollaborateurService;

@RestController
public class CollaborateurController {

	@Autowired
	CollaborateurService collaborateurService;

	@RequestMapping(value = "/responsable/collaborateur")
	public List<Collaborateur> findCollaborateurByComposanet(@RequestParam int idComposante) {
		return this.collaborateurService.findColllaborateursByComposante(idComposante);
	}

	@RequestMapping(value = "/responsable/collaborateurs")
	public List<Collaborateur> findAllCollaborateurs() {
		return this.collaborateurService.findAllCollaborateur();
	}
}
