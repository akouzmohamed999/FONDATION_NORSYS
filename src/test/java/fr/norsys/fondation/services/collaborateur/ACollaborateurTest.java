package fr.norsys.fondation.services.collaborateur;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.CollaborateurService;

public abstract class ACollaborateurTest extends AbstractTest {

	@Autowired
	CollaborateurService collaborateurService;

}
