package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

public class UpdateProjetTest extends AProjectTest {

	@Test
	public void shouldUpdateFirstProjet() {

		LocalDate lUpdateDateFinProjet1 = LocalDate.of(2017, 9, 9);
		Date UpdatedDateFinProjet1 = Date.valueOf(lUpdateDateFinProjet1);
		this.projet1.setDateFin(UpdatedDateFinProjet1);
		assertThat(this.projectService.updateProjet(this.projet1).getDateFin()).isEqualTo(UpdatedDateFinProjet1);
	}

}
