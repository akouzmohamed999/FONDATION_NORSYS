package fr.norsys.fondation.controller.collaborateur;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.MediaType;

public class UpdateCollaborateurControllerTest extends ACollaborateurControllerTest{
	
	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc
				.perform(put("/administrateur/updateCollaborateur").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.content("{\"idCollaborateur\":\"1\",\"nom\":\"TEST\"}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
						MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))))
				.andExpect(jsonPath("idCollaborateur", is(1))).andExpect(jsonPath("nom", is("TEST")));
	}


}
