package fr.norsys.fondation.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "PARTENAIRE")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idPartenaire")
public class Partenaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARTENAIRE")
	private int idPartenaire;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "ADRESSE")
	private String adresse;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "NUMERO_TELEPHONE")
	private String numeroTelephone;

	@ManyToMany
	@JoinTable(name = "PARTENAIRE_PROJET", joinColumns = {
			@JoinColumn(referencedColumnName = "ID_PARTENAIRE", name = "ID_PARTENAIRE") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "ID_PROJET", name = "ID_PROJET") })
	List<Projet> projets;

}
