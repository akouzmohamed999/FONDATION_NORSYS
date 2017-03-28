package fr.norsys.fondation.services.collaborateur;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.fondation.services.CollaborateurService;

public abstract class ACollaborateurTest {

	@Autowired
	CollaborateurService collaborateurService;

	@Before
	public void setUp() {

	}
}
