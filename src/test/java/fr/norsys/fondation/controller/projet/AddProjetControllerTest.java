package fr.norsys.fondation.controller.projet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AddProjetControllerTest extends AProjetControllerTest {

	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(post("/responsable/addProjet").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content("{\"intitule\":\"TEST\"}")).andExpect(status().isOk());
	}
}
