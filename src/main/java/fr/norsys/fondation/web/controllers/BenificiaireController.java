package fr.norsys.fondation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Benificiaire;
import fr.norsys.fondation.services.BenificiaireService;

@RestController
public class BenificiaireController {

	@Autowired
	BenificiaireService benificiaireService;

	@RequestMapping(value = "/responsable/addBenificiaire", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Benificiaire findCollaborateurByComposanet(@RequestBody Benificiaire benificiaire) {
		return this.benificiaireService.addBenificiaire(benificiaire);
	}
}
