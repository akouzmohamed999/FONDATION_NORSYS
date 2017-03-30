package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AddProjetTest extends AProjectTest {

	@Test
	public void shouldReturnInsertedProjet() {

		assertThat(this.projectService.addProjet(this.projet3)).isEqualTo(this.projet3);
		assertThat(this.projectService.findAllProjets().size()).isEqualTo(3);
		assertThat(this.projectService.findAllProjets().get(2)).isEqualTo(this.projet3);
	}
}
