package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindProjetByCategorie extends AProjectTest {

	@Test
	public void shouldReturnFormationProjetUsingCategorie() {

		assertThat(this.projectService.findProjetsByCategorie("Education").get(0)).isEqualTo(this.projet);
	}
}
