package fr.norsys.fondation.controller.activitie;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.MediaType;

public class AddActiviteControllerTest extends AActiviteControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc
				.perform(post("/responsable/addActivite").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.content("{\"intitule\":\"TEST\"}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
						MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))))
				.andExpect(jsonPath("idActivite", is(4))).andExpect(jsonPath("intitule", is("TEST")));
	}
}
