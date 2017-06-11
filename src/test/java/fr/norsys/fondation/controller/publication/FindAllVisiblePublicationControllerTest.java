package fr.norsys.fondation.controller.publication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class FindAllVisiblePublicationControllerTest extends APublicationControllerTest {

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(get("/public/visiblePublications")).andExpect(status().isOk());
	}
}
