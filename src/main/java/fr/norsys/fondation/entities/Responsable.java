package fr.norsys.fondation.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Responsable extends Collaborateur {
	private static final long serialVersionUID = 1L;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "responsable")
	private List<Projet> projets;

	public Responsable() {
		super();
	}

	public Responsable(String cIN, String nom, String prenom, String adresse, String numeroTelephone, String email,
			Date dateNaissance, String lieuNaissance) {
		super(cIN, nom, prenom, adresse, numeroTelephone, email, dateNaissance, lieuNaissance);
	}

	public List<Projet> getProjets() {
		return this.projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
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
		Responsable other = (Responsable) obj;
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
		return "Responsable [projets=" + this.projets + "]";
	}

}
