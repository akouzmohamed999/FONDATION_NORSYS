package fr.norsys.fondation.services.composante;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.norsys.fondation.entities.Composante;

public class AddComposanteTest extends AComposanteTest {

	@Test
	public void shouldAddComposante() {
		Composante composanteAjoute = new Composante(2, "intituleComposante2", this.ThematiqueAgriculture,
				this.projet1);
		assertThat(this.composanteService.addComposante(composanteAjoute).getIntitule())
				.isEqualTo(composanteAjoute.getIntitule());
	}
}
