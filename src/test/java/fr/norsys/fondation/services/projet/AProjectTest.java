package fr.norsys.fondation.services.projet;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.entities.Administrateur;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.entities.Responsable;
import fr.norsys.fondation.services.ProjetService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Test/ApplicationContextTest.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public abstract class AProjectTest {

	@Autowired
	ProjetService projectService;

	Administrateur administrateur;
	Responsable responsable;
	Collaborateur collaborateur1;
	Collaborateur collaborateur2;
	Projet projet;
	Activite activite1;
	Activite activite2;
	Activite activite3;

	@Before
	public void setUp() {

		LocalDate lDateDebutProjet = LocalDate.of(2017, 02, 01);
		Date dateDebutProjet = Date.valueOf(lDateDebutProjet);

		LocalDate lDateFinProjet = LocalDate.of(2017, 02, 03);
		Date dateFinProjet = Date.valueOf(lDateFinProjet);

		LocalDate lDateDebutActivite1 = LocalDate.of(2017, 02, 01);
		Date dateDebutActivite1 = Date.valueOf(lDateDebutActivite1);

		LocalDate lDateDebutActivite2 = LocalDate.of(2017, 02, 02);
		Date dateDebutActivite2 = Date.valueOf(lDateDebutActivite2);

		LocalDate lDateDebutActivite3 = LocalDate.of(2017, 02, 03);
		Date dateDebutActivite3 = Date.valueOf(lDateDebutActivite3);

		this.administrateur = new Administrateur(1, "J4879584", "akouz", "mohamed", "Rue 14 Hay massira", null, null,
				null, null);
		this.responsable = new Responsable(2, "J222222", "elkhaily", "morad", "Rue 14 Hay massira", null, null, null,
				null);
		this.collaborateur1 = new Collaborateur(3, "J333333", "youssfi", "youssef", "Rue 14 Hay massira", null, null,
				null, null);
		this.collaborateur2 = new Collaborateur(4, "J444444", "karami", "karim", "Rue 14 Hay massira", null, null, null,
				null);
		this.projet = new Projet(1, "formation professeur en informatique",
				"lobjectif de ce projet cest de former les professeur sur les outils informatiques", dateDebutProjet,
				dateFinProjet, "Education", this.administrateur, this.responsable, null);

		this.activite1 = new Activite(1, "Visite des lieux", dateDebutActivite1, "Matinee", "En Cours",
				"ecole x place y", this.collaborateur1, this.projet);

		this.activite2 = new Activite(2, "Reunion avec professeur", dateDebutActivite2, "Matinee", "En Cours",
				"ecole x place y", this.collaborateur1, this.projet);

		this.activite3 = new Activite(3, "Recontre des étudiant", dateDebutActivite3, "Matinee", "En Cours",
				"ecole x place y", this.collaborateur1, this.projet);

	}
}
