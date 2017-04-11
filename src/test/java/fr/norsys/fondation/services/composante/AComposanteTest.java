package fr.norsys.fondation.services.composante;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ComposanteService;

public abstract class AComposanteTest extends AbstractTest {

	@Autowired
	ComposanteService composanteService;
}
