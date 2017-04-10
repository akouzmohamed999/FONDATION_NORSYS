package fr.norsys.fondation.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "BENIFICIAIRE")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@administraturidCollaborateur")
public class Benificiaire {

	@Id
	@Column(name = "ID_BENIFICIAIRE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBenificiaire;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "CIN")
	private String CIN;
	@Column(name = "AGE")
	private int age;
	@Column(name = "PAYS")
	private String pays;
	@Column(name = "VILLE")
	private String ville;
	@Column(name = "ADRESSE")
	private String adresse;
	@Column(name = "NUMERO_TELEPHONE")
	private String numeroTelephone;
	@ManyToMany(mappedBy = "benificiaires")
	private List<Activite> activites;

}
