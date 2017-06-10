package fr.norsys.fondation.controller.proposition;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class AddPropositionControllerTest extends APropositionControllerTest {

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(post("/public/addProposition").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content("{\"objectif\":\"TEST\"}")).andExpect(status().isOk());
	}
}
