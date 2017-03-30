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
	Collaborateur collaborateur3;
	Collaborateur collaborateur4;
	Collaborateur collaborateur5;
	Collaborateur collaborateur6;

	Projet projet1;
	Activite activite1;
	Activite activite2;
	Activite activite3;

	Projet projet2;
	Activite activite4;
	Activite activite5;
	Activite activite6;

	@Before
	public void setUp() {

		LocalDate lDateDebutProjet1 = LocalDate.of(2017, 03, 11);
		Date dateDebutProjet1 = Date.valueOf(lDateDebutProjet1);

		LocalDate lDateFinProjet1 = LocalDate.of(2017, 03, 16);
		Date dateFinProjet1 = Date.valueOf(lDateFinProjet1);

		LocalDate lDateDebutActivite1 = LocalDate.of(2017, 03, 12);
		Date dateDebutActivite1 = Date.valueOf(lDateDebutActivite1);

		LocalDate lDateDebutActivite2 = LocalDate.of(2017, 03, 14);
		Date dateDebutActivite2 = Date.valueOf(lDateDebutActivite2);

		LocalDate lDateDebutActivite3 = LocalDate.of(2017, 03, 15);
		Date dateDebutActivite3 = Date.valueOf(lDateDebutActivite3);

		this.administrateur = new Administrateur(1, "J4879584", "akouz", "mohamed", "Rue 14 Hay massira", null, null,
				null, null);
		this.responsable = new Responsable(2, "J222222", "elkhaily", "morad", "Rue 14 Hay massira", null, null, null,
				null);
		this.collaborateur1 = new Collaborateur(3, "J333333", "youssfi", "youssef", "Rue 14 Hay massira", null, null,
				null, null);
		this.collaborateur2 = new Collaborateur(4, "J444444", "karami", "karim", "Rue 14 Hay massira", null, null, null,
				null);
		this.collaborateur3 = new Collaborateur(5, "EB5678", "samir", "bennareg", "Rue 14 Hay agadir", null, null, null,
				null);
		this.collaborateur4 = new Collaborateur(6, "EB5679", "elkhaily", "smail", "Rue 14 Hay ffffff", null, null, null,
				null);
		this.collaborateur5 = new Collaborateur(7, "J333333", "youssfi", "smail", "Rue 14 Hay fffddff", null, null,
				null, null);
		this.collaborateur6 = new Collaborateur(8, "J444444", "youssfi", "smail", "Rue 14 Hay fffddff", null, null,
				null, null);

		// ---------------------------------projet1----------------------------------

		this.projet1 = new Projet(1, "formation professeur en informatique",
				"lobjectif de ce projet cest de former les professeur sur les outils informatiques", dateDebutProjet1,
				dateFinProjet1, "Education", this.administrateur, this.responsable, null);

		this.activite1 = new Activite(1, "Visite des lieux", dateDebutActivite1, "Matinee", "En Cours",
				"ecole x place y", this.collaborateur1, this.projet1);

		this.activite2 = new Activite(2, "Reunion avec professeur", dateDebutActivite2, "Matinee", "En Cours",
				"ecole x place y", this.collaborateur1, this.projet1);

		this.activite3 = new Activite(3, "Recontre des étudiant", dateDebutActivite3, "Matinee", "En Cours",
				"ecole x place y", this.collaborateur1, this.projet1);

		// ---------------------------------projet2----------------------------------

		LocalDate lDateDebutProjet2 = LocalDate.of(2017, 05, 11);
		Date dateDebutProjet2 = Date.valueOf(lDateDebutProjet2);

		LocalDate lDateFinProjet2 = LocalDate.of(2017, 05, 20);
		Date dateFinProjet2 = Date.valueOf(lDateFinProjet2);

		LocalDate lDateDebutActivite4 = LocalDate.of(2017, 05, 12);
		Date dateDebutActivite4 = Date.valueOf(lDateDebutActivite4);

		LocalDate lDateDebutActivite5 = LocalDate.of(2017, 05, 13);
		Date dateDebutActivite5 = Date.valueOf(lDateDebutActivite5);

		LocalDate lDateDebutActivite6 = LocalDate.of(2017, 05, 14);
		Date dateDebutActivite6 = Date.valueOf(lDateDebutActivite6);

		this.projet2 = new Projet(2, "devlopement du lieu educatif d'une ecole",
				"lobjectif de ce projet c'est de proposer des cour de soir pour une ecole", dateDebutProjet2,
				dateFinProjet2, "developement", this.administrateur, this.responsable, null);

		this.activite4 = new Activite(4, "jjjjjjjjj", dateDebutActivite4, "Matinee", "En Cour", "ecole x place y",
				this.collaborateur1, this.projet2);

		this.activite5 = new Activite(5, "ffffffff", dateDebutActivite5, "Matinee", "En Cour", "ecole x place y",
				this.collaborateur3, this.projet2);

		this.activite6 = new Activite(6, "jjjjjjjjjj", dateDebutActivite6, "Matinee", "En Cour", "ecole x place y",
				this.collaborateur4, this.projet2);

	}
}