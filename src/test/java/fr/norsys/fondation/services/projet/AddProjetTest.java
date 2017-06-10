package fr.norsys.fondation.services.projet;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

import fr.norsys.fondation.entities.Projet;

public class AddProjetTest extends AProjectTest {

	@Test
	public void shouldReturnInsertedProjet() {

		LocalDate lDateDebutProjetAjoute = LocalDate.of(2017, 06, 06);
		Date dateDebutProjetAjoute = Date.valueOf(lDateDebutProjetAjoute);

		LocalDate lDateFinProjetAjoute = LocalDate.of(2017, 06, 16);
		Date dateFinProjetAjoute = Date.valueOf(lDateFinProjetAjoute);

		this.projetAAjoute = new Projet(2, "intituleProjetAjoute", "descriptionProjetAjoute", dateDebutProjetAjoute,
				dateFinProjetAjoute, this.administrateur1, this.responsableProjet1, null);
		assertThat(this.projectService.addProjet(this.projetAAjoute).getIntitule())
				.isEqualTo(this.projetAAjoute.getIntitule());
	}
}
