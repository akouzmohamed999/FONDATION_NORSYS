package fr.norsys.fondation.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PROJET")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idProjet")
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

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Administrateur.class)
	@JoinColumn(name = "ID_ADMINISTRATEUR")
	@JsonManagedReference
	private Administrateur administrateur;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "projet")
	@JsonManagedReference
	private List<Composante> composantes = new ArrayList<Composante>();

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Responsable.class)
	@JoinColumn(name = "ID_RESPONSABLE")
	@JsonManagedReference
	private Responsable responsable;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "projet")
	@JsonManagedReference
	private List<Publication> publications = new ArrayList<Publication>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "projets")
	@JsonManagedReference
	private List<Partenaire> partenaires = new ArrayList<Partenaire>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "projet")
	@JsonManagedReference
	private List<RapportProjet> rapports = new ArrayList<RapportProjet>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "projet")
	@JsonManagedReference
	private List<BilanProjet> bilans = new ArrayList<BilanProjet>();

	@OneToOne(fetch = FetchType.LAZY, targetEntity = Proposition.class)
	@JoinColumn(name = "ID_PROPOSITION")
	@Null
	private Proposition proposition;

	public Projet() {
	}

	public Projet(int idProjet, String intitule, String description, Date dateDebut, Date dateFin,
			Administrateur administrateur, Responsable responsable, Proposition proposition) {
		this.idProjet = idProjet;
		this.intitule = intitule;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.administrateur = administrateur;
		administrateur.getProjets().add(this);
		this.responsable = responsable;
		responsable.getProjets().add(this);
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

	public Administrateur getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public List<Composante> getComposantes() {
		return this.composantes;
	}

	public void setComposantes(List<Composante> composantes) {
		this.composantes = composantes;
	}

	public Responsable getResponsable() {
		return this.responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public List<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public List<Partenaire> getPartenaires() {
		return this.partenaires;
	}

	public void setPartenaires(List<Partenaire> partenaires) {
		this.partenaires = partenaires;
	}

	public List<RapportProjet> getRapports() {
		return this.rapports;
	}

	public void setRapports(List<RapportProjet> rapports) {
		this.rapports = rapports;
	}

	public List<BilanProjet> getBilans() {
		return this.bilans;
	}

	public void setBilans(List<BilanProjet> bilans) {
		this.bilans = bilans;
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
		result = prime * result + (this.administrateur == null ? 0 : this.administrateur.hashCode());
		result = prime * result + (this.dateDebut == null ? 0 : this.dateDebut.hashCode());
		result = prime * result + (this.dateFin == null ? 0 : this.dateFin.hashCode());
		result = prime * result + (this.description == null ? 0 : this.description.hashCode());
		result = prime * result + this.idProjet;
		result = prime * result + (this.intitule == null ? 0 : this.intitule.hashCode());
		result = prime * result + (this.proposition == null ? 0 : this.proposition.hashCode());
		result = prime * result + (this.responsable == null ? 0 : this.responsable.hashCode());
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
		if (this.administrateur == null) {
			if (other.administrateur != null) {
				return false;
			}
		} else if (!this.administrateur.equals(other.administrateur)) {
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
		if (this.proposition == null) {
			if (other.proposition != null) {
				return false;
			}
		} else if (!this.proposition.equals(other.proposition)) {
			return false;
		}
		if (this.responsable == null) {
			if (other.responsable != null) {
				return false;
			}
		} else if (!this.responsable.equals(other.responsable)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Projet [idProjet=" + this.idProjet + ", intitule=" + this.intitule + ", description=" + this.description
				+ ", dateDebut=" + this.dateDebut + ", dateFin=" + this.dateFin + ", categorie=" + ", administrateur="
				+ this.administrateur + ", composantes number=" + this.composantes.size() + ", responsable="
				+ this.responsable + ", proposition=" + this.proposition + "]";
	}

}
