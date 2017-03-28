package fr.norsys.fondation.services.collaborateur;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Test/ApplicationContext.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })

@DatabaseSetup("/dataset.xml")

public class FindCollaborateurByNameTest extends ACollaborateurTest {

	@Test
	public void shouldReturnMohamedwhenNomIsAkouz() {
		assertThat(this.collaborateurService.findCollaborateurByName("akouz").getPrenom()).isEqualTo("mohamed");
		assertThat(this.collaborateurService.findCollaborateurByName("akouz").getCIN()).isEqualTo("J4879584");
		assertThat(this.collaborateurService.findCollaborateurByName("akouz").getAdresse())
				.isEqualTo("Rue 14 Hay massira");
	}
}
