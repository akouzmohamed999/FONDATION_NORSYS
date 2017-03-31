package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindActivitiesByGerantTest extends AActiviteTest {

	@Test
	public void shouldReturnActivitie1AndUsingYoussef() {
		assertThat(this.activiteService.findActivitiesByGerant(this.collaborateur1).size()).isEqualTo(6);
	}
}
