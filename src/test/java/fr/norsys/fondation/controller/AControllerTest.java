package fr.norsys.fondation.controller;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.norsys.fondation.repositories.ProjetRepository;
import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ProjetService;
import fr.norsys.fondation.web.controllers.ProjetController;

public abstract class AControllerTest extends AbstractTest {

	@InjectMocks
	ProjetController projetController;

	@Mock
	ProjetService projetService;
	MockMvc mockMvc;

	@Mock
	ProjetRepository projetRepository;

	@Before
	public void launch() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.projetController).build();
	}

}
