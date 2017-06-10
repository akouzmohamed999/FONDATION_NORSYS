package fr.norsys.fondation.controller.composante;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class DeleteComposanteControllerTest extends AComponsanteControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(delete("/responsable/deleteComposante").param("idComposante", "1"))
				.andExpect(status().isOk());
	}
}
