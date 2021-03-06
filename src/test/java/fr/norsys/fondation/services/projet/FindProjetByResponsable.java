package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindProjetByResponsable extends AProjectTest {

	@Test
	public void souldReturnFormationProjetUsingResponsable() {

		assertThat(this.projectService.findProjetsByResponsable(this.responsableProjet1.getIdCollaborateur()).get(0))
				.isEqualTo(this.projet1);

	}
}
