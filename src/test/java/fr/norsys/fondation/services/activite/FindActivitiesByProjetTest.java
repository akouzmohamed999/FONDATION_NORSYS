package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindActivitiesByProjetTest extends AActiviteTest {

	@Test
	public void shouldReturnProjet1Activities() {

		assertThat(this.activiteService.findActivitiesByProjet(this.projet1).size()).isEqualTo(3);

		assertThat(this.activiteService.findActivitiesByProjet(this.projet1).get(0))
				.isEqualTo(this.activiteProjet1EnCours1);

		assertThat(this.activiteService.findActivitiesByProjet(this.projet1).get(1))
				.isEqualTo(this.activiteProjet1EnCours2);

		assertThat(this.activiteService.findActivitiesByProjet(this.projet1).get(2))
				.isEqualTo(this.activiteProjet1Termine1);
	}
}
