package fr.norsys.fondation.controller.administrateur;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class deleteAdministrateurControllerTest extends AAdministrateurControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(delete("/administrateur/deleteAdministrateur").param("idAdministrateur", "1"))
				.andExpect(status().isOk());
	}
}
