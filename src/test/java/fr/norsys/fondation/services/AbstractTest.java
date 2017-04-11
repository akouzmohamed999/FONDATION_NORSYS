package fr.norsys.fondation.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.entities.Administrateur;
import fr.norsys.fondation.entities.Benificiaire;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.entities.Composante;
import fr.norsys.fondation.entities.Partenaire;
import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.entities.Responsable;
import fr.norsys.fondation.entities.Thematique;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/ApplicationContextTest.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public abstract class AbstractTest {

	@Autowired
	protected ActiviteService activiteService;

	protected Administrateur administrateur1;
	protected Responsable responsableProjet1;
	protected Benificiaire benificiaire1Activite1And2Projet1;
	protected Benificiaire benificiaire2Activite1And2Projet1;
	protected Partenaire partenaire1Projet1;
	protected Partenaire partenaire2Projet1;

	protected Collaborateur collaborateur1;
	protected Collaborateur collaborateur2;
	protected Collaborateur collaborateur3;
	protected Collaborateur collaborateur4;
	protected Collaborateur collaborateur5;
	protected Collaborateur collaborateur6;

	protected Thematique ThematiqueSensiblisation;
	protected Thematique ThematiqueAgriculture;

	protected Projet projet1;
	protected Composante composante1Projet1;
	protected Activite activite1Composante1Projet1Termine;
	protected Activite activite2Composante1Projet1EnCours;
	protected Activite activite3Composante1Projet1Annule;

	protected Projet projetAAjoute;
	protected Activite activteAAjoute;

	@Before
	public void setUp() {

		LocalDate lDateDebutProjet1 = LocalDate.of(2017, 03, 11);
		Date dateDebutProjet1 = Date.valueOf(lDateDebutProjet1);

		LocalDate lDateFinProjet1 = LocalDate.of(2017, 03, 16);
		Date dateFinProjet1 = Date.valueOf(lDateFinProjet1);

		LocalDate lDateDebutProjetAjoute = LocalDate.of(2017, 06, 06);
		Date dateDebutProjetAjoute = Date.valueOf(lDateDebutProjetAjoute);

		LocalDate lDateFinProjetAjoute = LocalDate.of(2017, 06, 16);
		Date dateFinProjetAjoute = Date.valueOf(lDateFinProjetAjoute);

		LocalDate lDateDebutActivite1 = LocalDate.of(2017, 03, 12);
		Date dateDebutActivite1 = Date.valueOf(lDateDebutActivite1);

		LocalDate lDateDebutActivite2 = LocalDate.of(2017, 03, 13);
		Date dateDebutActivite2 = Date.valueOf(lDateDebutActivite2);

		LocalDate lDateDebutActivite3 = LocalDate.of(2017, 03, 14);
		Date dateDebutActivite3 = Date.valueOf(lDateDebutActivite3);

		LocalDate lDateDebutActiviteAjoute = LocalDate.of(2017, 03, 15);
		Date dateDebutActiviteAjoute = Date.valueOf(lDateDebutActiviteAjoute);

		this.administrateur1 = new Administrateur(1, "A1111", "nomAdministrateur1", "prenomAdministrateur1",
				"adresseAdministrateur1", null, null, null, null);

		this.responsableProjet1 = new Responsable(2, "R1111", "nomResponsable1", "prenomResponsable1",
				"adresseResponsable1", null, null, null, null, null);
		this.collaborateur1 = new Collaborateur(3, "C1111", "nomCollaborateur1", "prenomCollaborateur1",
				"adresseCollaborateur1", null, null, null, null);
		this.collaborateur2 = new Collaborateur(4, "C2222", "nomCollaborateur2", "prenomCollaborateur2",
				"adresseCollaborateur2", null, null, null, null);
		this.collaborateur3 = new Collaborateur(5, "C3333", "nomCollaborateur3", "prenomCollaborateur3",
				"adresseCollaborateur3", null, null, null, null);
		this.collaborateur4 = new Collaborateur(6, "C4444", "nomCollaborateur4", "prenomCollaborateur4",
				"adresseCollaborateur4", null, null, null, null);
		this.collaborateur5 = new Collaborateur(7, "C5555", "nomCollaborateur5", "prenomCollaborateur5",
				"adresseCollaborateur5", null, null, null, null);
		this.collaborateur6 = new Collaborateur(8, "C6666", "nomCollaborateur6", "prenomCollaborateur6",
				"adresseCollaborateur6", null, null, null, null);

		this.partenaire1Projet1 = new Partenaire(1, "Partenaire1", "ASSOCIATION", "AdressePartenaire1",
				"EmailPartenaire1", "06060606");

		this.partenaire2Projet1 = new Partenaire(2, "Partenaire2", "ASSOCIATION", "AdressePartenaire2",
				"EmailPartenaire2", "06060606");

		this.benificiaire1Activite1And2Projet1 = new Benificiaire(1, "nomBenificaire1", "prenomBenificiaire1", "B1111",
				"paysBenificiaire1", "villeBenificiaire1", "adresseBenificiaire1");

		this.benificiaire2Activite1And2Projet1 = new Benificiaire(2, "nomBenificaire2", "prenomBenificiaire2", "B2222",
				"paysBenificiaire2", "villeBenificiaire2", "adresseBenificiaire2");

		// ---------------------------------projet1----------------------------------

		this.ThematiqueSensiblisation = new Thematique(1, "Sensibilisation", "descriptionThmatique1");
		this.ThematiqueAgriculture = new Thematique(2, "Agriculture", "descriptionThmatique2");

		this.projet1 = new Projet(1, "intituleProjet1", "descriptionProjet1", dateDebutProjet1, dateFinProjet1,
				this.administrateur1, this.responsableProjet1, null);

		this.projet1.getPartenaires().addAll(Arrays.asList(this.partenaire1Projet1, this.partenaire2Projet1));

		this.composante1Projet1 = new Composante(1, "intituleComposante1", this.ThematiqueSensiblisation, this.projet1);

		this.activite1Composante1Projet1Termine = new Activite(1, "intituleActivite1", dateDebutActivite1,
				"dureeActivite1", "Termine", "lieuActivite1", this.collaborateur1, this.composante1Projet1,
				Arrays.asList(this.benificiaire1Activite1And2Projet1, this.benificiaire2Activite1And2Projet1));

		this.activite2Composante1Projet1EnCours = new Activite(2, "intituleActivite2", dateDebutActivite2,
				"dureeActivite2", "En Cours", "lieuActivite2", this.collaborateur1, this.composante1Projet1,
				Arrays.asList(this.benificiaire1Activite1And2Projet1, this.benificiaire2Activite1And2Projet1));

		this.activite3Composante1Projet1Annule = new Activite(3, "intituleActivite3", dateDebutActivite3,
				"dureeActivite3", "Annule", "lieuActivite3", this.collaborateur1, this.composante1Projet1);

		this.activite1Composante1Projet1Termine
				.setCollaborateurs(Arrays.asList(this.collaborateur1, this.collaborateur2));

		this.activteAAjoute = new Activite(1, "intituleActiviteAjoute", dateDebutActiviteAjoute, "dureeAcitiviteAjoute",
				"En Cours", "lieu Activite Ajoute", this.collaborateur1, this.composante1Projet1);

		this.collaborateur2.getActivites().add(this.activite1Composante1Projet1Termine);
		this.collaborateur3.getActivites().add(this.activite1Composante1Projet1Termine);

		this.collaborateur4.getActivites().add(this.activite2Composante1Projet1EnCours);
		this.collaborateur5.getActivites().add(this.activite2Composante1Projet1EnCours);

		// ---------------------------------ADDEDPORJET----------------------------------

		this.projetAAjoute = new Projet(2, "intituleProjetAjoute", "descriptionProjetAjoute", dateDebutProjetAjoute,
				dateFinProjetAjoute, this.administrateur1, this.responsableProjet1, null);
	}

}
