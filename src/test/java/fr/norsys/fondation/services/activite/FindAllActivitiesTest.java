package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/ApplicationContextTest.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class FindAllActivitiesTest extends AActiviteTest {

	@Test
	public void shouldReturnAllActivities() {

		assertThat(this.activiteService.findAllActivities().size()).isEqualTo(3);

		assertThat(this.activiteService.findAllActivities().get(0)).isEqualTo(this.activite1Composante1Projet1Termine);
		assertThat(this.activiteService.findAllActivities().get(1)).isEqualTo(this.activite2Composante1Projet1EnCours);
		assertThat(this.activiteService.findAllActivities().get(2)).isEqualTo(this.activite3Composante1Projet1Annule);

	}
}
