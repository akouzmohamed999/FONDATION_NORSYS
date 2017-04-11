package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindActivitiesByComposanteTest extends AActiviteTest {

	@Test
	public void shouldReturnProjet1Composante1Activities() {

		assertThat(this.activiteService.findActivitiesByComposante(this.composante1Projet1).size()).isEqualTo(3);

		assertThat(this.activiteService.findActivitiesByComposante(this.composante1Projet1).get(0))
				.isEqualTo(this.activite1Composante1Projet1Termine);

		assertThat(this.activiteService.findActivitiesByComposante(this.composante1Projet1).get(1))
				.isEqualTo(this.activite2Composante1Projet1EnCours);

		assertThat(this.activiteService.findActivitiesByComposante(this.composante1Projet1).get(2))
				.isEqualTo(this.activite3Composante1Projet1Annule);
	}
}
