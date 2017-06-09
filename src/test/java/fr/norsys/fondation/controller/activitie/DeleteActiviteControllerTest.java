package fr.norsys.fondation.controller.activitie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class DeleteActiviteControllerTest extends AActiviteControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(delete("/responsable/deleteActivite").param("idActivite", "1")).andExpect(status().isOk());
	}
}
