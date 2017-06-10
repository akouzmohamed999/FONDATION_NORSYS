package fr.norsys.fondation.controller.porteurProjet;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ProjetService;
import fr.norsys.fondation.web.controllers.PorteurProjetController;

public abstract class APorteurControllerTest extends AbstractTest {

	@Autowired
	PorteurProjetController porteurProjetController;

	@Autowired
	ProjetService projetService;

	MockMvc mockMvc;

	@Before
	public void launch() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.porteurProjetController).build();
	}
}
