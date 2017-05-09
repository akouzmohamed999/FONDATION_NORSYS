package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/administrateur/composante", method = RequestMethod.GET)
	public List<Composante> findComposanteByIdProjet(@RequestParam int idProjet) {
		return this.composanteService.findCompetitionsByIdProjet(idProjet);
	}

	@RequestMapping(value = "/responsable/composanteById", method = RequestMethod.GET)
	public Composante findComposanteById(@RequestParam int idComposante) {
		return this.composanteService.findComposanteById(idComposante);
	}

	@RequestMapping(value = "/responsable/addComposante", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Composante addComponsante(@RequestBody Composante composante) {
		System.out.println("LA COMPOSANTE A AJOUTE EST : " + composante);
		return this.composanteService.addComposante(composante);
	}

	@RequestMapping(value = "/responsable/updateComposante", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Composante updateComponsante(@RequestBody Composante composante) {
		System.out.println("LA COMPOSANTE MiSE A JOUR EST : " + composante);
		return this.composanteService.updateComposante(composante);
	}

	@RequestMapping(value = "/responsable/deleteComposante", method = RequestMethod.DELETE)
	public void deleteComponsante(@RequestParam int idComposante) {
		Composante composante = this.composanteService.findComposanteById(idComposante);
		System.out.println("LA COMPOSANTE SUPPRIME EST : " + composante);
		this.composanteService.deleteComposante(composante);
	}

}
