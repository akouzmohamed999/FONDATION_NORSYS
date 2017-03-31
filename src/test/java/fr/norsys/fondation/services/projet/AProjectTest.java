package fr.norsys.fondation.services.projet;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ProjetService;

public abstract class AProjectTest extends AbstractTest {

	@Autowired
	ProjetService projectService;

}