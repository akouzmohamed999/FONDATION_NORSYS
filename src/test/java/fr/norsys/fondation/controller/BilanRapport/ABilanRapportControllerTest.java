package fr.norsys.fondation.controller.BilanRapport;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ProjetService;
import fr.norsys.fondation.web.controllers.ActiviteController;
import fr.norsys.fondation.web.controllers.BilanRapportController;

public abstract class ABilanRapportControllerTest extends AbstractTest{

	@Autowired
	BilanRapportController bilanRapportController;

	@Autowired
	ProjetService composanteService;

	MockMvc mockMvc;

	@Before
	public void launch() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.bilanRapportController).build();
	}
}
