package fr.norsys.fondation.services.composante;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindComposanteByIdProjetTest extends AComposanteTest {

	@Test
	public void shouldReturnCompetition1WhenUsingProjetId1() {
		assertThat(this.composanteService.findCompetitionsByIdProjet(this.projet1.getIdProjet()).size()).isEqualTo(1);
		assertThat(this.composanteService.findCompetitionsByIdProjet(this.projet1.getIdProjet()).get(0))
				.isEqualTo(this.composante1Projet1);
	}
}
