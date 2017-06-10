package fr.norsys.fondation.controller.publication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class AddPublicationControllerTest extends APublicationControllerTest {

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(post("/administrateur/addPublication").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content("{\"sujet\":\"TEST\"}")).andExpect(status().isOk());
	}
}
