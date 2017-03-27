package fr.norsys.fondation.services.collaborateur;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.norsys.fondation.entities.Collaborateur;

public class FindCollaborateurByNameTest extends ACollaborateurTest {

	@Test
	public void shouldReturnMohamedwhenNomIsAkouz() {

		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setNom("akouz");
		collaborateur.setPrenom("mohamed");
		assertThat(this.collaborateurService.findCollaborateurByName("akouz")).isEqualTo(collaborateur);
	}
}
