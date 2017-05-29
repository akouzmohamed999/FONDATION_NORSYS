package fr.norsys.fondation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Administrateur;
import fr.norsys.fondation.services.AdministrateurService;

@RestController
public class AdministrateurController {
	
	@Autowired
	AdministrateurService administrateurService;
	
	@RequestMapping(value = "/administrateur/addAdministrateur", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Administrateur addAdministrateur(@RequestBody Administrateur administrateur) {
		return this.administrateurService.addAdministrateur(administrateur);
	}
	
	@RequestMapping(value = "/administrateur/updateAdministrateur", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Administrateur updateAdministrateur(@RequestBody Administrateur administrateur) {
		return this.administrateurService.updateAdministrateur(administrateur);
	}
	
	@RequestMapping(value = "/administrateur/deleteAdministrateur")
	public void deleteAdministrateur(@RequestParam int idAdministrateur) {
		 this.administrateurService.deleteAdministrateur(this.administrateurService.findAdministrateurById(idAdministrateur));
	}

}
