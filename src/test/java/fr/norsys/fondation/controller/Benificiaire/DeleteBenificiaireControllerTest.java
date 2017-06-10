package fr.norsys.fondation.controller.Benificiaire;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class DeleteBenificiaireControllerTest extends ABenificiaireControllerTest{
	
	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(delete("/responsable/deleteBenificiaires").param("idBenificiaire", "1")).andExpect(status().isOk());
	}
}
