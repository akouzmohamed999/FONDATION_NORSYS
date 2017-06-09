package fr.norsys.fondation.controller.composante;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ProjetService;
import fr.norsys.fondation.web.controllers.ComposanteController;

public abstract class AComponsanteControllerTest extends AbstractTest {

	@Autowired
	ComposanteController composanteController;

	@Autowired
	ProjetService composanteService;

	MockMvc mockMvc;

	@Before
	public void launch() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.composanteController).build();
	}

}
