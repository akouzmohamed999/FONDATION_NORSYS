package fr.norsys.fondation.controller.collaborateur;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class AddCollaborateurControllerTest extends ACollaborateurControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(post("/administrateur/AddCollaborateur").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content("{\"nom\":\"TEST\"}")).andExpect(status().isOk());
	}
}
