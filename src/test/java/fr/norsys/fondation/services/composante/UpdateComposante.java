package fr.norsys.fondation.services.composante;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class UpdateComposante extends AComposanteTest {

	@Test
	public void shouldReturnUpdatedComposante() {
		this.composante1Projet1.setIntitule("Updated Intitule");
		assertThat(this.composanteService.updateComposante(this.composante1Projet1).getIntitule())
				.isEqualTo("Updated Intitule");
	}
}
