package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.services.ProjetService;

@RestController
public class ProjetController {

	@Autowired
	ProjetService projetService;

	@RequestMapping(value = { "/", "/projet" })
	public List<Projet> test() {
		return this.projetService.findAllProjets();
	}
}
