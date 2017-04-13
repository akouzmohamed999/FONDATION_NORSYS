package fr.norsys.fondation.controller.composante;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.MediaType;

public class FindComposanteByIdProjetControllerTest extends AComponsanteControllerTest {

	@Test
	public void shouldReturnJsonWithComposanteId1Projets() throws Exception {
		this.mockMvc.perform(get("/composante").param("idProjet", "1")).andExpect(status().isOk())
				.andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
						MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))))
				.andExpect(jsonPath("$[0].idComposante", is(1)))
				.andExpect(jsonPath("$[0].intitule", is("intituleComposante1")))
				.andExpect(jsonPath("$[0].thematique.idThematique", is(1)));
	}

}
