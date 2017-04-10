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
@Table(name = "PUBLICATION")
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PUBLICATION")
	private int idPublication;

	@Column(name = "TITRE")
	private String titre;

	@Column(name = "DESCRIPTION")
	private String description;

	@Lob
	@Column(name = "photo")
	private byte[] photo;

	@ManyToOne
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;
}
