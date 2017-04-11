package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RemoveActiviteTest extends AActiviteTest {

	@Test
	public void shouldRemove3rdActivity() {
		this.activiteService.removeActivite(this.activite3Composante1Projet1Annule);
		assertThat(this.activiteService.findAcitiviteById(3)).isNull();
	}
}
