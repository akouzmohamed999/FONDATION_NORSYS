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
		result = prime * result + ((fichierBilan == null) ? 0 : fichierBilan.hashCode());
		result = prime * result + idBilan;
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((projet == null) ? 0 : projet.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BilanProjet other = (BilanProjet) obj;
		if (fichierBilan == null) {
			if (other.fichierBilan != null)
				return false;
		} else if (!fichierBilan.equals(other.fichierBilan))
			return false;
		if (idBilan != other.idBilan)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (projet == null) {
			if (other.projet != null)
				return false;
		} else if (!projet.equals(other.projet))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BilanProjet [idBilan=" + idBilan + ", intitule=" + intitule + ", type=" + type + ", fichierBilan="
				+ fichierBilan + ", projet=" + projet + "]";
	}

	

}
