package fr.norsys.fondation.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RendezVous {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RENDEZVOUS")
	private int idRendezVous;

	@Column(name = "DATE")
	private Timestamp date;

	private String sujet;

	private PorteurProjet porteurProjet;

	private Administrateur administrateur;

}
