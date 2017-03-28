package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindProjetByIntitule extends AProjectTest {

	@Test
	public void shouldReturnProjet1WhenIntituleIsSchool() {
		assertThat(
				this.projectService.findProjetsByIntitule("formation professeur en informatique").get(0).getIdProjet())
						.isEqualTo(1);
		// assertThat(this.projectService.findProjetsByIntitule("formation
		// professeur en informatique").get(0).getIdProjet()).isEqua

	}
}
