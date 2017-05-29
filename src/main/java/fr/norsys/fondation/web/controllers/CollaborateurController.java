package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/administrateur/collaborateurById")
	public Collaborateur findCollaborateurByIdCollaborateur(@RequestParam int idCollaborateur) {
		return this.collaborateurService.findCollaborateurByIdCollaborateur(idCollaborateur);
	}

	@RequestMapping(value = "/responsable/collaborateurs")
	public List<Collaborateur> findCollaborateurs() {
		return this.collaborateurService.findAllCollaborateur();
	}
	
	@RequestMapping(value = "/responsable/allCollaborateurs")
	public List<Collaborateur> findCollaborateursOnly() {
		return this.collaborateurService.findCollaborateurs();
	}
	
	
	@RequestMapping(value = "/administrateur/administrateurs")
	public List<Administrateur> findAllAdministrateur() {
		return this.administrateurService.findAllAdministrateur();
	}


	@RequestMapping(value = "/administrateur/responsables")
	public List<Responsable> findAllResponsables() {
		return this.responsableService.findAllResponsables();

	}

	@RequestMapping(value = "/administrateur/adminById")
	public Administrateur findAdminById(@RequestParam int idAdministrateur) {
		return this.administrateurService.findAdministrateurById(idAdministrateur);
	}

	@RequestMapping(value = "/administrateur/AddCollaborateur", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Collaborateur AddCollaborateur(@RequestBody Collaborateur collaborateur) {
		return this.collaborateurService.AddCollaborateur(collaborateur);
	}

	@RequestMapping(value = "/administrateur/updateCollaborateur", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Collaborateur updateCollaborateur(@RequestBody Collaborateur collaborateur) {
		return this.collaborateurService.updateCollaborateur(collaborateur);
	}

	@RequestMapping(value = "/administrateur/DeleteCollaborateur", method = RequestMethod.DELETE)
	public void DeleteCollaborateur(@RequestParam int idCollaborateur) {
		Collaborateur collaborateur = this.collaborateurService.findCollaborateurByIdCollaborateur(idCollaborateur);
		this.collaborateurService.DeleteCollaborateur(collaborateur);
	}

}
