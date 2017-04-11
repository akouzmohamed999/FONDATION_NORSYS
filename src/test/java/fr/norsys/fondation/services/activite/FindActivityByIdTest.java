package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindActivityByIdTest extends AActiviteTest {

	@Test
	public void shouldReturnActivity1Projet1WhenUsingId1() {

		assertThat(this.activiteService.findAcitiviteById(this.activite1Composante1Projet1Termine.getIdActivite()))
				.isEqualTo(this.activite1Composante1Projet1Termine);
	}
}
