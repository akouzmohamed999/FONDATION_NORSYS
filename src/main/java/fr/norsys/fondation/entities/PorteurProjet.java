package fr.norsys.fondation.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PORTEUR_PROJET")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idPorteur")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class PorteurProjet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PORTEUR")
	private int idPorteur;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "NUMERO_TELEPHONE")
	private String numeroTelephone;
	@OneToMany(mappedBy = "porteurProjet")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<Proposition> propositions = new ArrayList<Proposition>();

	public PorteurProjet() {
	}

	public PorteurProjet(int idPorteur, String nom, String prenom, String email, String numeroTelephone) {
		super();
		this.idPorteur = idPorteur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numeroTelephone = numeroTelephone;
	}

	public int getIdPorteur() {
		return this.idPorteur;
	}

	public void setIdPorteur(int idPorteur) {
		this.idPorteur = idPorteur;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroTelephone() {
		return this.numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public List<Proposition> getPropositions() {
		return this.propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idPorteur;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((numeroTelephone == null) ? 0 : numeroTelephone.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PorteurProjet other = (PorteurProjet) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idPorteur != other.idPorteur)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numeroTelephone == null) {
			if (other.numeroTelephone != null)
				return false;
		} else if (!numeroTelephone.equals(other.numeroTelephone))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PorteurProjet [idPorteur=" + idPorteur + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", numeroTelephone=" + numeroTelephone + "]";
	}

	
}
