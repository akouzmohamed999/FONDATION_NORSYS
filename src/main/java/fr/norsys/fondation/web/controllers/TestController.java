package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.services.CollaborateurService;

@RestController
public class TestController {

	@Autowired
	CollaborateurService collaborateurService;

	@RequestMapping(value = "/test")
	public List<Collaborateur> test() {
		this.collaborateurService.AddCollaborateur("AKOUZ", "MOHAMED");
		return this.collaborateurService.findAllCollaborateur();
	}
}
