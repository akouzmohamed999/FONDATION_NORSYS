package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Administrateur;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.entities.Responsable;
import fr.norsys.fondation.services.AdministrateurService;
import fr.norsys.fondation.services.CollaborateurService;
import fr.norsys.fondation.services.ResponsableService;

@RestController
public class CollaborateurController {

	@Autowired
	CollaborateurService collaborateurService;

	@Autowired
	ResponsableService responsableService;

	@Autowired
	AdministrateurService administrateurService;

	@RequestMapping(value = "/responsable/collaborateur")
	public List<Collaborateur> findCollaborateurByComposanet(@RequestParam int idComposante) {
		return this.collaborateurService.findColllaborateursByComposante(idComposante);
	}

	@RequestMapping(value = "/responsable/collaborateurs")
	public List<Collaborateur> findAllCollaborateurs() {
		return this.collaborateurService.findAllCollaborateur();
	}

	@RequestMapping(value = "/responsable/responsables")
	public List<Responsable> findAllResponsables() {
		return this.responsableService.findAllResponsables();
	}

	@RequestMapping(value = "/administrateur/adminById")
	public Administrateur findAdminById(@RequestParam int idAdministrateur) {
		return this.administrateurService.findAdministrateurById(idAdministrateur);
	}

}
