package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

public class FindProjetByDateTest extends AProjectTest {

	@Test
	public void shouldReturnFormationProjetUsingDateDebut() {
		LocalDate lTestDateDebut = LocalDate.of(2017, 3, 11);
		Date testDateDebut = Date.valueOf(lTestDateDebut);
		assertThat(this.projectService.findProjetsByDateDebut(testDateDebut).get(0)).isEqualTo(this.projet1);
	}

	@Test
	public void shouldReturnFormmationProjetUsingDateFin() {

		LocalDate lTestDateFin = LocalDate.of(2017, 3, 16);
		Date testDateFin = Date.valueOf(lTestDateFin);
		assertThat(this.projectService.findProjetsByDateFin(testDateFin).get(0)).isEqualTo(this.projet1);

	}

}
