package fr.norsys.fondation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BILAN")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idBilan")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class BilanProjet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BILAN")
	private int idBilan;
	@Column(name = "INTITULE")
	private String intitule;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "FICHIER_BILAN")
	private String fichierBilan;
	@ManyToOne
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;

	public BilanProjet() {
	}

	public int getIdBilan() {
		return this.idBilan;
	}

	public void setIdBilan(int idBilan) {
		this.idBilan = idBilan;
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

	public String getFichierBilan() {
		return this.fichierBilan;
	}

	public void setFichierBilan(String fichierBilan) {
		this.fichierBilan = fichierBilan;
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
		result = prime * result + (this.fichierBilan == null ? 0 : this.fichierBilan.hashCode());
		result = prime * result + this.idBilan;
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
		BilanProjet other = (BilanProjet) obj;
		if (this.fichierBilan == null) {
			if (other.fichierBilan != null) {
				return false;
			}
		} else if (!this.fichierBilan.equals(other.fichierBilan)) {
			return false;
		}
		if (this.idBilan != other.idBilan) {
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
		return "BilanProjet [idBilan=" + this.idBilan + ", intitule=" + this.intitule + ", type=" + this.type
				+ ", fichierBilan=" + this.fichierBilan + ", projet=" + this.projet + "]";
	}

}
