package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindAllActivitiesTest extends AActiviteTest {

	@Test
	public void shouldReturnAllActivities() {

		assertThat(this.activiteService.findAllActivities().size()).isEqualTo(6);
		assertThat(this.activiteService.findAllActivities().get(0)).isEqualTo(this.activite1);
		assertThat(this.activiteService.findAllActivities().get(1)).isEqualTo(this.activite2);
		assertThat(this.activiteService.findAllActivities().get(2)).isEqualTo(this.activite3);
		assertThat(this.activiteService.findAllActivities().get(3)).isEqualTo(this.activite4);
		assertThat(this.activiteService.findAllActivities().get(4)).isEqualTo(this.activite5);
		assertThat(this.activiteService.findAllActivities().get(5)).isEqualTo(this.activite6);

	}
}
