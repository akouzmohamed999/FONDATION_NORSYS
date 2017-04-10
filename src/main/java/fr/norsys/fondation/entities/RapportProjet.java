package fr.norsys.fondation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RAPPORT")
public class RapportProjet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RAPPORT")
	private int idRapport;
	@Column(name = "INTITULE")
	private String intitule;
	@Column(name = "TYPE")
	private String type;
	@Lob
	@Column(name = "fichierRapport")
	private byte[] fichierRapport;
	@ManyToOne
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;

}
