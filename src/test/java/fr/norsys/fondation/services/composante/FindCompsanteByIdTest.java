package fr.norsys.fondation.services.composante;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindCompsanteByIdTest extends AComposanteTest {

	@Test
	public void shouldReturnCompsante1WhenUsingId1() {
		assertThat(this.composanteService.findComposanteById(this.composante1Projet1.getIdComposante()))
				.isEqualTo(this.composante1Projet1);
	}
}
