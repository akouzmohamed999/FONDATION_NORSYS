package fr.norsys.fondation.web.controllers;

import java.security.Principal;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.services.CollaborateurService;

@RestController
public class SessionController {

	@Autowired
	CollaborateurService collaborateurService;

	@RequestMapping("/user/loggedUser")
	public Collaborateur getLoggedUser(Principal principal) throws SQLException {
		Collaborateur collaborateur = this.collaborateurService.findCollaborateurByName(principal.getName());
		return collaborateur;
	}
}
