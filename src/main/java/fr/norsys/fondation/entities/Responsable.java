package fr.norsys.fondation.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@responsableidCollaborateur")
public class Responsable extends Collaborateur {

	private static final long serialVersionUID = 1L;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "responsable")
	@JsonBackReference
	private List<Projet> projets = new ArrayList<Projet>();

	public Responsable() {
	}

	public Responsable(int idCollaborateur, String cIN, String nom, String prenom, String adresse,
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
		return "Responsable [projets Number =" + this.projets.size() + "]";
	}

}
