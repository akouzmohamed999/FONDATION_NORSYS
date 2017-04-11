package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AddActivitieTest extends AActiviteTest {

	@Test
	public void shouldReturnInsertedActivitie() {
		assertThat(this.activiteService.addActivite(this.activteAAjoute)).isEqualTo(this.activteAAjoute);
	}
}
