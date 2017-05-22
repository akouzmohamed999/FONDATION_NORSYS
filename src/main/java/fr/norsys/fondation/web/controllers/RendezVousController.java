package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.RendezVous;
import fr.norsys.fondation.services.RendezVousService;

@RestController
public class RendezVousController {

	@Autowired
	RendezVousService rendezVousService;

	@RequestMapping(value = "/administrateur/addRendezVous", method = RequestMethod.POST)
	public RendezVous addRendezVous(@RequestBody RendezVous rendezVous) {
		return this.rendezVousService.addRendezVous(rendezVous);
	}

	@RequestMapping(value = "/administrateur/allRendezVous")
	public List<RendezVous> findAllRendezVous() {
		return this.rendezVousService.findAllRendezVous();
	}

	@RequestMapping(value = "/administrateur/updateRendezVous", method = RequestMethod.PUT)
	public RendezVous updateRendezVous(@RequestBody RendezVous rendezVous) {
		return this.rendezVousService.updateRendezVous(rendezVous);
	}

	@RequestMapping(value = "/administrateur/deleteRendezVous", method = RequestMethod.DELETE)
	public void deleteRendezVous(@RequestParam int idRendezVous) {
		this.rendezVousService.deleteRendezVous(this.rendezVousService.findRendezVousById(idRendezVous));
	}

}
