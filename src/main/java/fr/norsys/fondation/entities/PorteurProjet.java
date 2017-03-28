package fr.norsys.fondation.entities;

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

@Entity
@Table(name = "PORTEUR_PROJET")
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
	private List<Proposition> propositions;

	public PorteurProjet() {
		super();
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
		result = prime * result + (this.email == null ? 0 : this.email.hashCode());
		result = prime * result + this.idPorteur;
		result = prime * result + (this.nom == null ? 0 : this.nom.hashCode());
		result = prime * result + (this.numeroTelephone == null ? 0 : this.numeroTelephone.hashCode());
		result = prime * result + (this.prenom == null ? 0 : this.prenom.hashCode());
		result = prime * result + (this.propositions == null ? 0 : this.propositions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		PorteurProjet other = (PorteurProjet) obj;
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!this.email.equals(other.email)) {
			return false;
		}
		if (this.idPorteur != other.idPorteur) {
			return false;
		}
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!this.nom.equals(other.nom)) {
			return false;
		}
		if (this.numeroTelephone == null) {
			if (other.numeroTelephone != null) {
				return false;
			}
		} else if (!this.numeroTelephone.equals(other.numeroTelephone)) {
			return false;
		}
		if (this.prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!this.prenom.equals(other.prenom)) {
			return false;
		}
		if (this.propositions == null) {
			if (other.propositions != null) {
				return false;
			}
		} else if (!this.propositions.equals(other.propositions)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PorteurProjet [idPorteur=" + this.idPorteur + ", nom=" + this.nom + ", prenom=" + this.prenom
				+ ", email=" + this.email + ", numeroTelephone=" + this.numeroTelephone + ", propositions="
				+ this.propositions + "]";
	}

}
