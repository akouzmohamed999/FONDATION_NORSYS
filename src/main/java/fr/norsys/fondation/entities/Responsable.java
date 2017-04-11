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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@responsableidCollaborateur")
public class Responsable extends Collaborateur {

	private static final long serialVersionUID = 1L;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "responsable")
	private List<Projet> projets;

	public Responsable() {
		super();
	}

	public Responsable(int idCollaborateur, String cIN, String nom, String prenom, String adresse,
			String numeroTelephone, String email, Date dateNaissance, String lieuNaissance, List<Activite> activites) {
		super(idCollaborateur, cIN, nom, prenom, adresse, numeroTelephone, email, dateNaissance, lieuNaissance,
				activites);
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
