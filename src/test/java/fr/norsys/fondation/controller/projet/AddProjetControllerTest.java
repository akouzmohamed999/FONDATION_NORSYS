package fr.norsys.fondation.controller.projet;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AddProjetControllerTest extends AProjetControllerTest {

	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc
				.perform(post("/responsable/addProjet").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.content("{\"intitule\":\"TEST\"}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
						MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))))
				.andExpect(jsonPath("idProjet", is(2))).andExpect(jsonPath("intitule", is("TEST")));
	}
}
