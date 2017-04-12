package fr.norsys.fondation.services.composante;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindComposanteByThematiqueTest extends AComposanteTest {

	@Test
	public void shouldReturnComposante1WhenIdThematiqueIs1() {
		assertThat(this.composanteService.findComposanteByThematique(this.ThematiqueSensiblisation.getIdThematique()).get(0))
				.isEqualTo(this.composante1Projet1);
	}
}
