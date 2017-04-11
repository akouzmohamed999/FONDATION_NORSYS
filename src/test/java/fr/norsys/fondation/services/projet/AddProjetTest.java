package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AddProjetTest extends AProjectTest {

	@Test
	public void shouldReturnInsertedProjet() {

		assertThat(this.projectService.addProjet(this.projetAAjoute)).isEqualTo(this.projetAAjoute);
	}
}
