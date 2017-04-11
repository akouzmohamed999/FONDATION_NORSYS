package fr.norsys.fondation.services.composante;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FindAllComposanteTest extends AComposanteTest {

	@Test
	public void shouldReturnAllComposantes() {
		assertThat(this.composanteService.findAllComposantes().size()).isEqualTo(1);
		assertThat(this.composanteService.findAllComposantes().get(0)).isEqualTo(this.composante1Projet1);
	}
}
