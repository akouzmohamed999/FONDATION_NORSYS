package fr.norsys.fondation.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@administraturidCollaborateur")
public class Administrateur extends Collaborateur {

	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "administrateur")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Projet> projets;

	public Administrateur() {
		super();
	}

	public Administrateur(int idCollaborateur, String cIN, String nom, String prenom, String adresse,
			String numeroTelephone, String email, Date dateNaissance, String lieuNaissance) {
		super(idCollaborateur, cIN, nom, prenom, adresse, numeroTelephone, email, dateNaissance, lieuNaissance);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.projets == null ? 0 : this.projets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Administrateur other = (Administrateur) obj;
		if (this.projets == null) {
			if (other.projets != null) {
				return false;
			}
		} else if (!this.projets.equals(other.projets)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Administrateur [projets=" + this.projets + "]";
	}

	public List<Projet> getProjets() {
		return this.projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

}
