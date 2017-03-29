package fr.norsys.fondation.entities;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Collaborateur {

	private static final long serialVersionUID = 1L;

	public Administrateur() {
		super();
	}

	public Administrateur(int idCollaborateur, String cIN, String nom, String prenom, String adresse,
			String numeroTelephone, String email, Date dateNaissance, String lieuNaissance) {
		super(idCollaborateur, cIN, nom, prenom, adresse, numeroTelephone, email, dateNaissance, lieuNaissance);
	}

}
