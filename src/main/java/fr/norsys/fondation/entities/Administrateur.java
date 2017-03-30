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
