package fr.norsys.fondation.services.collaborateur;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindCollaborateurByNameTest extends ACollaborateurTest {

	@Test
	public void shouldReturnMohamedwhenNomIsAkouz() {
		assertThat(this.collaborateurService.findCollaborateurByName("akouz")).isEqualTo(this.administrateur);
	}
}
