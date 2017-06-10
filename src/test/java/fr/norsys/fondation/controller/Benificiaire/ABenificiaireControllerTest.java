package fr.norsys.fondation.controller.Benificiaire;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ProjetService;
import fr.norsys.fondation.web.controllers.AdministrateurController;
import fr.norsys.fondation.web.controllers.BenificiaireController;

public class ABenificiaireControllerTest extends AbstractTest{
	
	@Autowired
	BenificiaireController benificiaireController;

	@Autowired
	ProjetService composanteService;

	MockMvc mockMvc;

	@Before
	public void launch() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.benificiaireController).build();
	}

}
