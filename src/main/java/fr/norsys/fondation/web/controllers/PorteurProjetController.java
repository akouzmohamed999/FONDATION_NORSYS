package fr.norsys.fondation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.PorteurProjet;
import fr.norsys.fondation.services.PorteurProjetService;

@RestController
public class PorteurProjetController {

	@Autowired
	PorteurProjetService porteurProjetService;

	@RequestMapping(value = "/public/addPorteurProjet")
	public PorteurProjet addPorteurProjet(@RequestBody PorteurProjet porteurProjet) {
		return this.porteurProjetService.addPorteurProjet(porteurProjet);
	}
}
