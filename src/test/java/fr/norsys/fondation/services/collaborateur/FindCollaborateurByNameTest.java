package fr.norsys.fondation.services.collaborateur;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindCollaborateurByNameTest extends ACollaborateurTest {

	@Test
	public void shouldReturnMohamedwhenNomIsAkouz() {
		assertThat(this.collaborateurService.findCollaborateurByName("akouz").getPrenom()).isEqualTo("mohamed");
		assertThat(this.collaborateurService.findCollaborateurByName("akouz").getCIN()).isEqualTo("J4879584");
		assertThat(this.collaborateurService.findCollaborateurByName("akouz").getAdresse())
				.isEqualTo("Rue 14 Hay massira");
	}
}
