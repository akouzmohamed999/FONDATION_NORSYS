package fr.norsys.fondation.services.collaborateur;

import javax.sql.DataSource;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.fondation.repositories.CollaborateurRepository;
import fr.norsys.fondation.services.CollaborateurService;
import fr.norsys.fondation.services.impl.CollaborateurServiceImpl;

public abstract class ACollaborateurTest {

	@Mock
	DataSource dataSource;

	@Mock
	CollaborateurRepository collaborateurRepository;

	@InjectMocks
	CollaborateurService collaborateurService = new CollaborateurServiceImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
}
