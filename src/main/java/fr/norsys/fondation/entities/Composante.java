package fr.norsys.fondation.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "COMPOSANTE")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idComposante")
public class Composante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPOSANTE")
	private int idComposante;

	@Column(name = "INTITULE")
	private String intitule;

	@ManyToOne
	@JoinColumn(name = "ID_THEMATIQUE")
	private Thematique thematique;

	@ManyToOne
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;

	@OneToMany(mappedBy = "composante")
	private List<Activite> activites;

}
