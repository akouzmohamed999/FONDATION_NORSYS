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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "BILAN")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idBilan")
public class BilanProjet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BILAN")
	private int idBilan;
	@Column(name = "INTITULE")
	private String intitule;
	@Column(name = "TYPE")
	private String type;
	@Lob
	@Column(name = "fichierBilan")
	private byte[] fichierBilan;
	@ManyToOne
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;

}
