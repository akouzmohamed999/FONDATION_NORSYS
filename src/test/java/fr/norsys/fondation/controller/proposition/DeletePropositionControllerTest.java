package fr.norsys.fondation.controller.proposition;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class DeletePropositionControllerTest extends APropositionControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {

		this.mockMvc.perform(delete("/administrateur/deleteProposition").param("idProposition", "1"))
				.andExpect(status().isOk());
	}
}
