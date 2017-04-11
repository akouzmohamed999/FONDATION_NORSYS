package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class UpdateEtatActiviteTest extends AActiviteTest {

	@Test
	public void shouldChangeActiviteEtatToTermine() {
		this.activite2Composante1Projet1EnCours.setEtat("Termine");
		assertThat(this.activiteService.updateActiviteEtat(this.activite2Composante1Projet1EnCours).getEtat())
				.isEqualTo("Termine");
	}
}
