package fr.norsys.fondation.controller.publication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class DeletePublicationControllerTest extends APublicationControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(delete("/administrateur/deletePublication").param("idPublication", "1"))
				.andExpect(status().isOk());
	}
}
