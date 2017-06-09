package fr.norsys.fondation.services.collaborateur;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindAllCollaborateurTest extends ACollaborateurTest {

	@Test
	public void shouldReturnAll6Collaborateurs() {

		assertThat(this.collaborateurService.findAllCollaborateur().size()).isEqualTo(6);

		assertThat(this.collaborateurService.findAllCollaborateur().get(0)).isEqualTo(this.collaborateur1);
		assertThat(this.collaborateurService.findAllCollaborateur().get(1)).isEqualTo(this.collaborateur2);
		assertThat(this.collaborateurService.findAllCollaborateur().get(2)).isEqualTo(this.collaborateur3);
		assertThat(this.collaborateurService.findAllCollaborateur().get(3)).isEqualTo(this.collaborateur4);
		assertThat(this.collaborateurService.findAllCollaborateur().get(4)).isEqualTo(this.collaborateur5);
		assertThat(this.collaborateurService.findAllCollaborateur().get(5)).isEqualTo(this.collaborateur6);
	}
}
