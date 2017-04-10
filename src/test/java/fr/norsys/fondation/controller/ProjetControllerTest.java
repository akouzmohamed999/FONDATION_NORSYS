package fr.norsys.fondation.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.MediaType;

public class ProjetControllerTest extends AControllerTest {

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
						MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))))
				.andExpect(jsonPath("$[0].idProjet", is(1)))
				.andExpect(jsonPath("$[0].intitule", is("formation professeur en informatique")))
				.andExpect(jsonPath("$[0].description",
						is("lobjectif de ce projet cest de former les professeur sur les outils informatiques")));
	}

}
