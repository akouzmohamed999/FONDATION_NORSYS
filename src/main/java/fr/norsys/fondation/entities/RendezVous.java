package fr.norsys.fondation.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RENDEZ_VOUS")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idRendezVous")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class RendezVous {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RENDEZVOUS")
	private int idRendezVous;
	@Column(name = "DATE_RENDEZVOUS")
	private Date date;
	@Column(name = "SUJET")
	private String sujet;
	@ManyToOne
	@JoinColumn(name = "ID_PORTEUR_PROJET")
	private PorteurProjet porteurProjet;
	@ManyToOne
	@JoinColumn(name = "ID_ADMINISTRATEUR")
	private Administrateur administrateur;

	public RendezVous() {
	}

	public RendezVous(int idRendezVous, Date date, String sujet, PorteurProjet porteurProjet,
			Administrateur administrateur) {
		super();
		this.idRendezVous = idRendezVous;
		this.date = date;
		this.sujet = sujet;
		this.porteurProjet = porteurProjet;
		this.administrateur = administrateur;
	}

	public int getIdRendezVous() {
		return this.idRendezVous;
	}

	public void setIdRendezVous(int idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSujet() {
		return this.sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public PorteurProjet getPorteurProjet() {
		return this.porteurProjet;
	}

	public void setPorteurProjet(PorteurProjet porteurProjet) {
		this.porteurProjet = porteurProjet;
	}

	public Administrateur getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + idRendezVous;
		result = prime * result + ((porteurProjet == null) ? 0 : porteurProjet.hashCode());
		result = prime * result + ((sujet == null) ? 0 : sujet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RendezVous other = (RendezVous) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idRendezVous != other.idRendezVous)
			return false;
		if (porteurProjet == null) {
			if (other.porteurProjet != null)
				return false;
		} else if (!porteurProjet.equals(other.porteurProjet))
			return false;
		if (sujet == null) {
			if (other.sujet != null)
				return false;
		} else if (!sujet.equals(other.sujet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RendezVous [idRendezVous=" + idRendezVous + ", date=" + date + ", sujet=" + sujet + ", porteurProjet="
				+ porteurProjet + ", administrateur=" + administrateur + "]";
	}

	

}
