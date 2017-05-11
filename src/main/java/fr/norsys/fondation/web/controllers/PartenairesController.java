package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/administrateur/partenaireById", method = RequestMethod.GET)
	public Partenaire findPartenaireById(@RequestParam int idPartenaire) {
		return this.partenaireService.findPartenaireById(idPartenaire);
	}

	@RequestMapping(value = "/administrateur/addPartenaire", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Partenaire addPartenaires(@RequestBody Partenaire partenaire) {
		return this.partenaireService.addPartenaire(partenaire);
	}

	@RequestMapping(value = "/administrateur/updatePartenaire", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Partenaire updatePartenaires(@RequestBody Partenaire partenaire) {
		System.out.println("MISE A JOUR partenaire " + partenaire);
		return this.partenaireService.addPartenaire(partenaire);
	}

	@RequestMapping(value = "/administrateur/deletePartenaire", method = RequestMethod.DELETE)
	public void deletePartenaires(@RequestParam int idPartenaire) {
		Partenaire partenaire = this.partenaireService.findPartenaireById(idPartenaire);
		this.partenaireService.deletePartenaire(partenaire);
	}

}
