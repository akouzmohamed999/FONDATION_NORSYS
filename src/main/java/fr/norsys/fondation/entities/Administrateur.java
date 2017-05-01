package fr.norsys.fondation.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
// @JsonIdentityInfo(generator = JSOGGenerator.class)
// @JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class Administrateur extends Collaborateur {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "administrateur")
	// @LazyCollection(LazyCollectionOption.FALSE)
	@JsonBackReference
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
	public String toString() {
		return "Administrateur [projets number=" + this.projets.size() + "]";
	}

}
