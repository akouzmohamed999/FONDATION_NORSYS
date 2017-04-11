package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindActivitiesByAnimateurTest extends AActiviteTest {

	@Test
	public void shouldReturnActivitie1AndUsingCollaborateur1() {
		assertThat(
				this.activiteService.findActivitiesByAnimateurTerrain(this.collaborateur1.getIdCollaborateur()).size())
						.isEqualTo(3);
	}
}
