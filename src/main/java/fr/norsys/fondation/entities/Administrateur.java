package fr.norsys.fondation.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Administrateur extends Collaborateur {

	private static final long serialVersionUID = 1L;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "administrateur")
	private List<Projet> projets;

	public Administrateur() {
		super();
	}

	public Administrateur(String cIN, String nom, String prenom, String adresse, String numeroTelephone, String email,
			Date dateNaissance, String lieuNaissance) {
		super(cIN, nom, prenom, adresse, numeroTelephone, email, dateNaissance, lieuNaissance);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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

}
