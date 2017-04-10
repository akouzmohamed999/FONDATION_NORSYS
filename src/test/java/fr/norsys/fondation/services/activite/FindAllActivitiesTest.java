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

		assertThat(this.activiteService.findAllActivities().size()).isEqualTo(6);

		assertThat(this.activiteService.findAllActivities().get(0)).isEqualTo(this.activiteProjet1EnCours1);
		assertThat(this.activiteService.findAllActivities().get(1)).isEqualTo(this.activiteProjet1EnCours2);
		assertThat(this.activiteService.findAllActivities().get(2)).isEqualTo(this.activiteProjet1Termine1);
		assertThat(this.activiteService.findAllActivities().get(3)).isEqualTo(this.activiteProjet2EnCours4);
		assertThat(this.activiteService.findAllActivities().get(4)).isEqualTo(this.activiteProjet2Cloture1);
		assertThat(this.activiteService.findAllActivities().get(5)).isEqualTo(this.activiteProjet2EnCours5);

	}
}
