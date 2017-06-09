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

@Entity
@Table(name = "RAPPORT")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idRapport")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class RapportProjet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RAPPORT")
	private int idRapport;
	@Column(name = "INTITULE")
	private String intitule;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "FICHIER_RAPPORT")
	private String fichierRapport;
	@ManyToOne
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;

	public RapportProjet() {
	}

	public RapportProjet(int idRapport, String intitule, String type, String fichierRapport, Projet projet) {
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

	public String getFichierRapport() {
		return this.fichierRapport;
	}

	public void setFichierRapport(String fichierRapport) {
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
		result = prime * result + ((fichierRapport == null) ? 0 : fichierRapport.hashCode());
		result = prime * result + idRapport;
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
		RapportProjet other = (RapportProjet) obj;
		if (fichierRapport == null) {
			if (other.fichierRapport != null)
				return false;
		} else if (!fichierRapport.equals(other.fichierRapport))
			return false;
		if (idRapport != other.idRapport)
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
		return "RapportProjet [idRapport=" + idRapport + ", intitule=" + intitule + ", type=" + type
				+ ", fichierRapport=" + fichierRapport + ", projet=" + projet + "]";
	}

	

}
