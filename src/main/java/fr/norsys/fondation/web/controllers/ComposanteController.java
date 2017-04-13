package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Composante;
import fr.norsys.fondation.services.ComposanteService;

@RestController
public class ComposanteController {

	@Autowired
	ComposanteService composanteService;

	@RequestMapping(value = "/composante", method = RequestMethod.GET)
	public List<Composante> findComposanteByIdProjet(@RequestParam int idProjet) {
		return this.composanteService.findCompetitionsByIdProjet(idProjet);
	}
}
