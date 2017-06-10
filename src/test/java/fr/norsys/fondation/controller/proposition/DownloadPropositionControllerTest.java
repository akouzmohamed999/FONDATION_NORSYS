package fr.norsys.fondation.controller.proposition;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class DownloadPropositionControllerTest extends APropositionControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(get("/administrateur/downloadAnnexe").param("file", "Nuts.scss"))
				.andExpect(status().isOk());
	}
}
