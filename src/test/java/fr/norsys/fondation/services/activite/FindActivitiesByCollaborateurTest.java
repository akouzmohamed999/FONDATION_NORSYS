package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindActivitiesByCollaborateurTest extends AActiviteTest {

	@Test
	public void shouldReturnActivite1And2UsingCollaborateur1() {

		assertThat(this.activiteService.findActivitiesByCollaborateur(this.collaborateur2.getIdCollaborateur()).size())
				.isEqualTo(1);

		assertThat(this.activiteService.findActivitiesByCollaborateur(this.collaborateur2.getIdCollaborateur()).get(0))
				.isEqualTo(this.activite1Composante1Projet1Termine);

	}
}
