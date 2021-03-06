package fr.norsys.fondation.services.activite;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

public class FindActivitiesByDateActiviteTest extends AActiviteTest {

	@Test
	public void shouldReturnthingActivite4UsingDate20170512() {

		LocalDate lDateDebut = LocalDate.of(2017, 03, 13);
		Date dateDebutActivite = Date.valueOf(lDateDebut);
		assertThat(this.activiteService.findActivitiesByDateActivite(dateDebutActivite).get(0))
				.isEqualTo(this.activite2Composante1Projet1EnCours);
	}
}
