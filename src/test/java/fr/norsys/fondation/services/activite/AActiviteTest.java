package fr.norsys.fondation.services.activite;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import fr.norsys.fondation.services.AbstractTest;
import fr.norsys.fondation.services.ActiviteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Test/ApplicationContextTest.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public abstract class AActiviteTest extends AbstractTest {

	@Autowired
	protected ActiviteService activiteService;

}
