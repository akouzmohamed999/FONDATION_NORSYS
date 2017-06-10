package fr.norsys.fondation.controller.partenaire;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class DeletePartenaireControllerTest extends APartenaireControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(delete("/administrateur/deletePartenaire").param("idPartenaire", "1"))
				.andExpect(status().isOk());
	}
}
