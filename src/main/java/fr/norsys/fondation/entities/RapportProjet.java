package fr.norsys.fondation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "RAPPORT")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
// @JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class RapportProjet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RAPPORT")
	private int idRapport;
	@Column(name = "INTITULE")
	private String intitule;
	@Column(name = "TYPE")
	private String type;
	@Transient
	@Column(name = "FICHIER_RAPPORT")
	private byte[] fichierRapport;
	@ManyToOne
	@JoinColumn(name = "ID_PROJET")
	@JsonBackReference
	private Projet projet;

	public RapportProjet() {
	}

	public RapportProjet(int idRapport, String intitule, String type, byte[] fichierRapport, Projet projet) {
		super();
		this.idRapport = idRapport;
		this.intitule = intitule;
		this.type = type;
		this.fichierRapport = fichierRapport;
		this.projet = projet;
	}

	public int getIdRapport() {
		return this.idRapport;
	}

	public void setIdRapport(int idRapport) {
		this.idRapport = idRapport;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getFichierRapport() {
		return this.fichierRapport;
	}

	public void setFichierRapport(byte[] fichierRapport) {
		this.fichierRapport = fichierRapport;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.idRapport;
		result = prime * result + (this.intitule == null ? 0 : this.intitule.hashCode());
		result = prime * result + (this.projet == null ? 0 : this.projet.hashCode());
		result = prime * result + (this.type == null ? 0 : this.type.hashCode());
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
		RapportProjet other = (RapportProjet) obj;
		if (this.idRapport != other.idRapport) {
			return false;
		}
		if (this.intitule == null) {
			if (other.intitule != null) {
				return false;
			}
		} else if (!this.intitule.equals(other.intitule)) {
			return false;
		}
		if (this.projet == null) {
			if (other.projet != null) {
				return false;
			}
		} else if (!this.projet.equals(other.projet)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "RapportProjet [idRapport=" + this.idRapport + ", intitule=" + this.intitule + ", type=" + this.type
				+ ", projet=" + this.projet + "]";
	}

}
