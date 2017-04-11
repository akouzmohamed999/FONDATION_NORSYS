package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindAllActivitiesTest extends AActiviteTest {

	@Test
	public void shouldReturnAllActivities() {

		assertThat(this.activiteService.findAllActivities().size()).isEqualTo(3);

		assertThat(this.activiteService.findAllActivities().get(0)).isEqualTo(this.activite1Composante1Projet1Termine);
		assertThat(this.activiteService.findAllActivities().get(1)).isEqualTo(this.activite2Composante1Projet1EnCours);
		assertThat(this.activiteService.findAllActivities().get(2)).isEqualTo(this.activite3Composante1Projet1Annule);

	}
}
