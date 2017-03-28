package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

public class FindProjetByDateTest extends AProjectTest {

	@Test
	public void shouldReturnFormationProjetUsingDateDebut() {
		LocalDate lTestDateDebut = LocalDate.of(2017, 2, 1);
		Date testDateDebut = Date.valueOf(lTestDateDebut);
		assertThat(this.projectService.findProjetsByDateDebut(testDateDebut).get(0)).isEqualTo(this.projet);
	}
}
