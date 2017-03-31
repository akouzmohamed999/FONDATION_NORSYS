package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindActivitiesByEtatTest extends AActiviteTest {

	@Test
	public void shouldReturnActivite3WithTermineEtat() {
		assertThat(this.activiteService.findActivitiesByEtat("Termine").get(0)).isEqualTo(this.activiteProjet1Termine1);
	}

	@Test
	public void shouldReturnActivite5WithTermineEtat() {
		assertThat(this.activiteService.findActivitiesByEtat("Cloture").get(0)).isEqualTo(this.activiteProjet2Cloture1);
	}

	@Test
	public void shouldReturnActivite3WithEnCoursEtat() {
		assertThat(this.activiteService.findActivitiesByEtat("En Cours").size()).isEqualTo(4);
		assertThat(this.activiteService.findActivitiesByEtat("En Cours").get(0))
				.isEqualTo(this.activiteProjet1EnCours1);
		assertThat(this.activiteService.findActivitiesByEtat("En Cours").get(1))
				.isEqualTo(this.activiteProjet1EnCours2);
		assertThat(this.activiteService.findActivitiesByEtat("En Cours").get(2))
				.isEqualTo(this.activiteProjet2EnCours4);
		assertThat(this.activiteService.findActivitiesByEtat("En Cours").get(3))
				.isEqualTo(this.activiteProjet2EnCours5);
	}

}
