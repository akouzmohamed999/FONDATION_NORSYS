package fr.norsys.fondation.controller.composante;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class AddComposanteControllerClassTest extends AComponsanteControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(post("/responsable/addComposante").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content("{\"intitule\":\"TEST\"}")).andExpect(status().isOk());
	}

}
