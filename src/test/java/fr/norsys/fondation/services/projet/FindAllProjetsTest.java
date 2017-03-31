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

import fr.norsys.fondation.entities.Projet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/ApplicationContextTest.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class FindAllProjetsTest extends AProjectTest {

	@Test
	public void shouldReturnAllProjets() {
		List<Projet> projets = this.projectService.findAllProjets();
		assertThat(projets.size()).isEqualTo(2);
		assertThat(projets.get(0)).isEqualTo(this.projet1);
		assertThat(projets.get(1)).isEqualTo(this.projet2);
	}
}
