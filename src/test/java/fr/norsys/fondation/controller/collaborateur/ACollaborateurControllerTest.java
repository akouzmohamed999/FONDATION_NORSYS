package fr.norsys.fondation.controller.collaborateur;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ProjetService;
import fr.norsys.fondation.web.controllers.ActiviteController;
import fr.norsys.fondation.web.controllers.CollaborateurController;

public abstract class ACollaborateurControllerTest extends AbstractTest{

	@Autowired
	CollaborateurController collaborateurController;

	@Autowired
	ProjetService composanteService;

	MockMvc mockMvc;

	@Before
	public void launch() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.collaborateurController).build();
	}
}
