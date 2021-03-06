package fr.norsys.fondation.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@administraturidCollaborateur")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class Administrateur extends Collaborateur {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "administrateur")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<Projet> projets = new ArrayList<Projet>();

	public Administrateur() {
		super();
	}

	public Administrateur(int idCollaborateur, String cIN, String nom, String prenom, String adresse,
			String numeroTelephone, String email, String password, Date dateNaissance, String lieuNaissance) {
		super(idCollaborateur, cIN, nom, prenom, adresse, numeroTelephone, email, password, dateNaissance,
				lieuNaissance);
	}

	public List<Projet> getProjets() {
		return this.projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((projets == null) ? 0 : projets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrateur other = (Administrateur) obj;
		if (projets == null) {
			if (other.projets != null)
				return false;
		} else if (!projets.equals(other.projets))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrateur [projets number=" + this.projets.size() + "]";
	}

}
