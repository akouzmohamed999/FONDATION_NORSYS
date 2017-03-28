package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import fr.norsys.fondation.entities.Projet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Test/ApplicationContextTest.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })

@DatabaseSetup("/dataset.xml")

public class FindAllProjetsTest extends AProjectTest {

	@Test
	public void shouldReturnEcoleProjet() {
		List<Projet> projets = this.projectService.findAllProjets();
		assertThat(projets.size()).isEqualTo(1);
		assertThat(projets.get(0)).isEqualTo(this.projet);
	}
}
