package fr.norsys.fondation.controller.porteurProjet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class FindPorteurProjetByIdControllerTest extends APorteurControllerTest {

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(get("/administrateur/PorteurProjetById").param("idPorteurProjet", "1"))
				.andExpect(status().isOk());
	}

}
