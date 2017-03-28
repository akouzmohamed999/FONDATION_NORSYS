package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindProjetByIntitule extends AProjectTest {

	@Test
	public void shouldReturnFormationProjetUsingIntitule() {
		assertThat(this.projectService.findProjetsByIntitule("formation professeur en informatique").get(0))
				.isEqualTo(this.projet);

	}
}
