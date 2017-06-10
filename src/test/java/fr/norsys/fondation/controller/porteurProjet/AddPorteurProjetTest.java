package fr.norsys.fondation.controller.porteurProjet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class AddPorteurProjetTest extends APorteurControllerTest {

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(post("/public/addPorteurProjet").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content("{\"nom\":\"TEST\"}")).andExpect(status().isOk());
	}

}
