package fr.norsys.fondation.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "PROJET")
public class Projet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PROJET")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProjet;
	@Column(name = "INTITULE")
	private String intitule;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "DATE_DEBUT")
	private Date dateDebut;
	@Column(name = "DATE_FIN")
	private Date dateFin;
	@Column(name = "CATEGORIE")
	private String categorie;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Administrateur.class)
	@JoinColumn(name = "ID_ADMINISTRATEUR")
	private Administrateur administrateur;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "projet")
	private List<Activite> activites;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Responsable.class)
	@JoinColumn(name = "ID_RESPONSABLE")
	private Responsable responsable;
	@OneToOne(fetch = FetchType.LAZY, targetEntity = Proposition.class)
	@JoinColumn(name = "ID_PROPOSITION")
	@Null
	private Proposition proposition;

	public Projet() {
	}

	public Projet(int idProjet, String intitule, String description, Date dateDebut, Date dateFin, String categorie,
			Administrateur administrateur, Responsable responsable, Proposition proposition) {
		super();
		this.idProjet = idProjet;
		this.intitule = intitule;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.categorie = categorie;
		this.administrateur = administrateur;
		this.responsable = responsable;
		this.proposition = proposition;
	}

	public int getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Administrateur getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public List<Activite> getActivites() {
		return this.activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public Responsable getResponsable() {
		return this.responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Proposition getProposition() {
		return this.proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.categorie == null ? 0 : this.categorie.hashCode());
		result = prime * result + (this.dateDebut == null ? 0 : this.dateDebut.hashCode());
		result = prime * result + (this.dateFin == null ? 0 : this.dateFin.hashCode());
		result = prime * result + (this.description == null ? 0 : this.description.hashCode());
		result = prime * result + this.idProjet;
		result = prime * result + (this.intitule == null ? 0 : this.intitule.hashCode());
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
		Projet other = (Projet) obj;
		if (this.categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!this.categorie.equals(other.categorie)) {
			return false;
		}
		if (this.dateDebut == null) {
			if (other.dateDebut != null) {
				return false;
			}
		} else if (!this.dateDebut.equals(other.dateDebut)) {
			return false;
		}
		if (this.dateFin == null) {
			if (other.dateFin != null) {
				return false;
			}
		} else if (!this.dateFin.equals(other.dateFin)) {
			return false;
		}
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}
		if (this.idProjet != other.idProjet) {
			return false;
		}
		if (this.intitule == null) {
			if (other.intitule != null) {
				return false;
			}
		} else if (!this.intitule.equals(other.intitule)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Projet [idProjet=" + this.idProjet + ", intitule=" + this.intitule + ", description=" + this.description
				+ ", dateDebut=" + this.dateDebut + ", dateFin=" + this.dateFin + ", categorie=" + this.categorie
				+ ", activites number= " + this.activites.size() + "]";
	}

}
