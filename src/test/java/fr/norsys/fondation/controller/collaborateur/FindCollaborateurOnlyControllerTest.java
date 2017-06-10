package fr.norsys.fondation.controller.collaborateur;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.MediaType;

public class FindCollaborateurOnlyControllerTest extends ACollaborateurControllerTest{

	@Test
	public void shouldReturnJsonWith2Projets() throws Exception {
		this.mockMvc.perform(get("/administrateur/administrateurs")).andExpect(status().isOk())
				.andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
						MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))))
				.andExpect(jsonPath("$[0].idCollaborateur", is(1)));
	}
}
