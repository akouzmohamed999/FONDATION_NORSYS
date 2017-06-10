package fr.norsys.fondation.controller.proposition;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class FindAllPropositionFavorisTest extends APropositionControllerTest {

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(get("/administrateur/propositionsFavoris")).andExpect(status().isOk());
	}
}
