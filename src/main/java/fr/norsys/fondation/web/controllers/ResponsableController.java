package fr.norsys.fondation.web.controllers;

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
import fr.norsys.fondation.services.ResponsableService;

@RestController
public class ResponsableController {
	
	

	@Autowired
	ResponsableService responsableService;
	
	@RequestMapping(value = "/administrateur/addResponsable", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Responsable addAdministrateur(@RequestBody Responsable responsable) {
		return this.responsableService.addResponsable(responsable);
	}
	
	@RequestMapping(value = "/administrateur/updateResponsable", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Responsable updateAdministrateur(@RequestBody Responsable responsable) {
		return this.responsableService.updateResponsable(responsable);
	}
	
	@RequestMapping(value = "/administrateur/deleteResponsable")
	public void deleteAdministrateur(@RequestParam int idResponsable) {
		 this.responsableService.deleteResponsable(this.responsableService.findResponsableById(idResponsable));
	}

}
