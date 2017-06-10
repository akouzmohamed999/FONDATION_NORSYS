package fr.norsys.fondation.controller.administrateur;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ProjetService;
import fr.norsys.fondation.web.controllers.ActiviteController;
import fr.norsys.fondation.web.controllers.AdministrateurController;

public class AAdministrateurControllerTest extends AbstractTest{

	
	@Autowired
	AdministrateurController administrateurController;

	@Autowired
	ProjetService composanteService;

	MockMvc mockMvc;

	@Before
	public void launch() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.administrateurController).build();
	}
}
