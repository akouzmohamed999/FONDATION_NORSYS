package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Partenaire;
import fr.norsys.fondation.services.PartenaireService;

@RestController
public class PartenairesController {

	@Autowired
	PartenaireService partenaireService;

	@RequestMapping(value = "/administrateur/partenaires", method = RequestMethod.GET)
	public List<Partenaire> findAllPartenaires() {
		return this.partenaireService.findAllPartenaires();
	}

}
