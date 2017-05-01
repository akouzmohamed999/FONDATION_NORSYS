package fr.norsys.fondation.web.controllers;

import java.security.Principal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.services.CollaborateurService;

@RestController
public class SessionController {

	@Autowired
	CollaborateurService collaborateurService;

	@RequestMapping("/collaborateur/loggedUser")
	public Map<String, Object> getLoggedUser(Principal principal) throws SQLException {
		Collaborateur collaborateur = this.collaborateurService.findCollaborateurByEmail(principal.getName());
		Map<String, Object> collaborateurRole = new HashMap<String, Object>();
		collaborateurRole.put("Role", collaborateur.getClass().getSimpleName());
		collaborateurRole.put("Collaborateur", collaborateur);
		return collaborateurRole;
	}
}
