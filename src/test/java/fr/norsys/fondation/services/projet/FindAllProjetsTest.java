package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import fr.norsys.fondation.entities.Projet;

public class FindAllProjetsTest extends AProjectTest {

	@Test
	public void shouldReturnAllProjets() {
		List<Projet> projets = this.projectService.findAllProjets();
		assertThat(projets.size()).isEqualTo(2);
		assertThat(projets.get(0)).isEqualTo(this.projet1);
		assertThat(projets.get(1)).isEqualTo(this.projet2);
	}
}
