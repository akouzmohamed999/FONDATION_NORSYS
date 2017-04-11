package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindActivitiesByEtatTest extends AActiviteTest {

	@Test
	public void shouldReturnActivitesWithRequestedEtat() {

		assertThat(this.activiteService.findActivitiesByEtat("Termine").size()).isEqualTo(1);
		assertThat(this.activiteService.findActivitiesByEtat("En Cours").size()).isEqualTo(1);
		assertThat(this.activiteService.findActivitiesByEtat("Annule").size()).isEqualTo(1);

		assertThat(this.activiteService.findActivitiesByEtat("Termine").get(0))
				.isEqualTo(this.activite1Composante1Projet1Termine);
		assertThat(this.activiteService.findActivitiesByEtat("En Cours").get(0))
				.isEqualTo(this.activite2Composante1Projet1EnCours);
		assertThat(this.activiteService.findActivitiesByEtat("Annule").get(0))
				.isEqualTo(this.activite3Composante1Projet1Annule);

	}

}
