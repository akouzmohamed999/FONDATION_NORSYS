package fr.norsys.fondation.controller.administrateur;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class AddAdministrateurClassTest extends AAdministrateurControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(post("/administrateur/addAdministrateur")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"nom\":\"TEST\"}"))
				.andExpect(status().isOk());
	}
}
