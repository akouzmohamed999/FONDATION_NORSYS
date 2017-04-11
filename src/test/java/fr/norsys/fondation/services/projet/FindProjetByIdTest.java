package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindProjetByIdTest extends AProjectTest {

	@Test
	public void shouldReturnProjet1WhenId1() {
		assertThat(this.projectService.findProjetById(this.projet1.getIdProjet())).isEqualTo(this.projet1);
	}
}
