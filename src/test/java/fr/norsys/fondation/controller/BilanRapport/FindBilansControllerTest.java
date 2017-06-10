package fr.norsys.fondation.controller.BilanRapport;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.MediaType;

public class FindBilansControllerTest extends ABilanRapportControllerTest{
	
	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(get("/responsable/bilans")).andExpect(status().isOk());
	}

}
