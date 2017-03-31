package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindActivitiesByCollaborateurTest extends AActiviteTest {

	@Test
	public void shouldReturnActivite1And2UsingCollaborateur1() {

		assertThat(this.activiteService.findActivitiesByCollaborateur(this.collaborateur1).size()).isEqualTo(2);

		assertThat(this.activiteService.findActivitiesByCollaborateur(this.collaborateur1).get(0))
				.isEqualTo(this.activiteProjet1EnCours1);

		assertThat(this.activiteService.findActivitiesByCollaborateur(this.collaborateur1).get(1))
				.isEqualTo(this.activiteProjet2EnCours4);
	}
}
