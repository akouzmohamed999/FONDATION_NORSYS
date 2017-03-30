package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

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
