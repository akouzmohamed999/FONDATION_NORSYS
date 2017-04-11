package fr.norsys.fondation.services.activite;

import org.junit.Test;

public class FindActivitiesByAnimateurTest extends AActiviteTest {

	@Test
	public void shouldReturnActivitie1AndUsingCollaborateur1() {
		assertThat(this.activiteService.findActivitiesByAnimateurTerrain(this.collaborateur1).size()).isEqualTo(3);
	}
}
