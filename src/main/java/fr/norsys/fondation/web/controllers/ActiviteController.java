package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.services.ActiviteService;

@RestController
public class ActiviteController {

	@Autowired
	ActiviteService activiteService;

	@RequestMapping(value = "/collaborateur/activite", method = RequestMethod.GET)
	public List<Activite> findComposanteByIdProjet(@RequestParam int idComposante) {
		return this.activiteService.findActivitiesByComposante(idComposante);
	}
}
