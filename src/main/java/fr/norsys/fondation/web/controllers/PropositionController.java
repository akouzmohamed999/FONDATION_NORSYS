package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Proposition;
import fr.norsys.fondation.services.PropositionService;

@RestController
public class PropositionController {

	@Autowired
	PropositionService propositionService;

	@RequestMapping(value = "/public/addProposition", method = RequestMethod.POST)
	public Proposition addproposition(@RequestBody Proposition proposition) {
		return this.propositionService.addProposition(proposition);
	}

	@RequestMapping(value = "/administrateur/propositions")
	public List<Proposition> findAllProposition() {
		return this.propositionService.findAllProposition();
	}

	@RequestMapping(value = "/administrateur/propositionsNonVue")
	public List<Proposition> findNonVueProposition() {
		return this.propositionService.findNonVuePropositions();
	}

	@RequestMapping(value = "/administrateur/propositionsFavoris")
	public List<Proposition> findFavorisProposition() {
		return this.propositionService.findFavorisPropositions();
	}

	@RequestMapping(value = "/administrateur/deleteProposition", method = RequestMethod.DELETE)
	public Proposition deleteProposition(@RequestParam int idProposition) {
		return this.propositionService.addProposition(this.propositionService.findPropositionById(idProposition));
	}
}
