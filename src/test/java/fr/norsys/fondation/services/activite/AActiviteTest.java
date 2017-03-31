package fr.norsys.fondation.services.activite;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ActiviteService;

public abstract class AActiviteTest extends AbstractTest {

	@Autowired
	protected ActiviteService activiteService;

}
