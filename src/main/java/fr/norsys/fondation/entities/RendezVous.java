package fr.norsys.fondation.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RENDEZ_VOUS")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
// @JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class RendezVous {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RENDEZVOUS")
	private int idRendezVous;
	@Column(name = "DATE")
	private Timestamp date;
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

	public RendezVous(int idRendezVous, Timestamp date, String sujet, PorteurProjet porteurProjet,
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

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
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
		result = prime * result + (this.administrateur == null ? 0 : this.administrateur.hashCode());
		result = prime * result + (this.date == null ? 0 : this.date.hashCode());
		result = prime * result + this.idRendezVous;
		result = prime * result + (this.porteurProjet == null ? 0 : this.porteurProjet.hashCode());
		result = prime * result + (this.sujet == null ? 0 : this.sujet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		RendezVous other = (RendezVous) obj;
		if (this.administrateur == null) {
			if (other.administrateur != null) {
				return false;
			}
		} else if (!this.administrateur.equals(other.administrateur)) {
			return false;
		}
		if (this.date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!this.date.equals(other.date)) {
			return false;
		}
		if (this.idRendezVous != other.idRendezVous) {
			return false;
		}
		if (this.porteurProjet == null) {
			if (other.porteurProjet != null) {
				return false;
			}
		} else if (!this.porteurProjet.equals(other.porteurProjet)) {
			return false;
		}
		if (this.sujet == null) {
			if (other.sujet != null) {
				return false;
			}
		} else if (!this.sujet.equals(other.sujet)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "RendezVous [idRendezVous=" + this.idRendezVous + ", date=" + this.date + ", sujet=" + this.sujet
				+ ", porteurProjet=" + this.porteurProjet + ", administrateur=" + this.administrateur + "]";
	}

}
