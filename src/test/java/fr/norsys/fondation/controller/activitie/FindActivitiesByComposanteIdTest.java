package fr.norsys.fondation.controller.activitie;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.MediaType;

public class FindActivitiesByComposanteIdTest extends AActiviteControllerTest {

	@Test
	public void shouldReturnJsonWithComposantesOfProjet1() throws Exception {
		this.mockMvc.perform(get("/activite").param("idComposante", "1")).andExpect(status().isOk())
				.andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
						MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))))
				.andExpect(jsonPath("$[0].idActivite", is(1)))
				.andExpect(jsonPath("$[0].intitule", is("intituleActivite1")))
				.andExpect(jsonPath("$[0].composante.idComposante", is(1)));
	}
}
