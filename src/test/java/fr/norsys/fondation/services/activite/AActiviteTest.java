package fr.norsys.fondation.services.activite;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.fondation.services.ActiviteService;

public abstract class AActiviteTest {

	@Autowired
	ActiviteService activiteService;

	@Before
	public void setUp() {

	}
}
