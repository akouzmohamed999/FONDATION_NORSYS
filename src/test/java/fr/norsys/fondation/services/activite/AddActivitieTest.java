package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AddActivitieTest extends AActiviteTest {

	@Test
	public void shouldReturnInsertedActivitie() {
		assertThat(this.activiteService.addActivite(this.addedActivite)).isEqualTo(this.addedActivite);
		assertThat(this.activiteService.findAllActivities().size()).isEqualTo(7);
	}
}
