package fr.norsys.fondation.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROPOSITION")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idProposition")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class Proposition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROPOSITION")
	private int idProposition;
	@Column(name = "THEMATIQUE")
	private String thematique;
	@Column(name = "OBJECTIF")
	private String objectif;
	@Column(name = "TYPE_ACTION")
	private String typeAction;
	@Column(name = "DATE_PREVISION")
	private Date datePrevision;
	@Column(name = "POPULATION_CIBLE")
	private String populationCible;
	@Column(name = "ZONE_GEOGRAPHIQUE")
	private String zoneGeographiqe;
	@Column(name = "DUREE_ACTION")
	private String dureeAction;
	@Column(name = "BUDGET_PREVISIONNEL")
	private String budgetPrevisionnel;
	@Column(name = "TYPE_SOUTIEN")
	private String typeSoutien;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = PorteurProjet.class)
	@JoinColumn(name = "ID_PORTEUR_PROJET")
	private PorteurProjet porteurProjet;
	@Column(name = "ANNEXE")
	private String Annexe;
	@Column(name = "ETAT")
	private String etat;

	public Proposition() {
	}

	public Proposition(int idProposition, String thematique, String objectif, String typeAction, Date datePrevision,
			String populationCible, String zoneGeographiqe, String dureeAction, String budgetPrevisionnel,
			String typeSoutien, PorteurProjet porteurProjet) {
		super();
		this.idProposition = idProposition;
		this.thematique = thematique;
		this.objectif = objectif;
		this.typeAction = typeAction;
		this.datePrevision = datePrevision;
		this.populationCible = populationCible;
		this.zoneGeographiqe = zoneGeographiqe;
		this.dureeAction = dureeAction;
		this.budgetPrevisionnel = budgetPrevisionnel;
		this.typeSoutien = typeSoutien;
		this.porteurProjet = porteurProjet;
	}

	public int getIdProposition() {
		return this.idProposition;
	}

	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
	}

	public String getThematique() {
		return this.thematique;
	}

	public void setThematique(String thematique) {
		this.thematique = thematique;
	}

	public String getObjectif() {
		return this.objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getTypeAction() {
		return this.typeAction;
	}

	public void setTypeAction(String typeAction) {
		this.typeAction = typeAction;
	}

	public Date getDatePrevision() {
		return this.datePrevision;
	}

	public void setDatePrevision(Date datePrevision) {
		this.datePrevision = datePrevision;
	}

	public String getPopulationCible() {
		return this.populationCible;
	}

	public void setPopulationCible(String populationCible) {
		this.populationCible = populationCible;
	}

	public String getZoneGeographiqe() {
		return this.zoneGeographiqe;
	}

	public void setZoneGeographiqe(String zoneGeographiqe) {
		this.zoneGeographiqe = zoneGeographiqe;
	}

	public String getDureeAction() {
		return this.dureeAction;
	}

	public void setDureeAction(String dureeAction) {
		this.dureeAction = dureeAction;
	}

	public String getBudgetPrevisionnel() {
		return this.budgetPrevisionnel;
	}

	public void setBudgetPrevisionnel(String budgetPrevisionnel) {
		this.budgetPrevisionnel = budgetPrevisionnel;
	}

	public String getTypeSoutien() {
		return this.typeSoutien;
	}

	public void setTypeSoutien(String typeSoutien) {
		this.typeSoutien = typeSoutien;
	}

	public PorteurProjet getPorteurProjet() {
		return this.porteurProjet;
	}

	public void setPorteurProjet(PorteurProjet porteurProjet) {
		this.porteurProjet = porteurProjet;
	}

	public String getAnnexe() {
		return this.Annexe;
	}

	public void setAnnexe(String annexe) {
		this.Annexe = annexe;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.budgetPrevisionnel == null ? 0 : this.budgetPrevisionnel.hashCode());
		result = prime * result + (this.datePrevision == null ? 0 : this.datePrevision.hashCode());
		result = prime * result + (this.dureeAction == null ? 0 : this.dureeAction.hashCode());
		result = prime * result + this.idProposition;
		result = prime * result + (this.objectif == null ? 0 : this.objectif.hashCode());
		result = prime * result + (this.populationCible == null ? 0 : this.populationCible.hashCode());
		result = prime * result + (this.thematique == null ? 0 : this.thematique.hashCode());
		result = prime * result + (this.typeAction == null ? 0 : this.typeAction.hashCode());
		result = prime * result + (this.typeSoutien == null ? 0 : this.typeSoutien.hashCode());
		result = prime * result + (this.zoneGeographiqe == null ? 0 : this.zoneGeographiqe.hashCode());
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
		Proposition other = (Proposition) obj;
		if (this.budgetPrevisionnel == null) {
			if (other.budgetPrevisionnel != null) {
				return false;
			}
		} else if (!this.budgetPrevisionnel.equals(other.budgetPrevisionnel)) {
			return false;
		}
		if (this.datePrevision == null) {
			if (other.datePrevision != null) {
				return false;
			}
		} else if (!this.datePrevision.equals(other.datePrevision)) {
			return false;
		}
		if (this.dureeAction == null) {
			if (other.dureeAction != null) {
				return false;
			}
		} else if (!this.dureeAction.equals(other.dureeAction)) {
			return false;
		}
		if (this.idProposition != other.idProposition) {
			return false;
		}
		if (this.objectif == null) {
			if (other.objectif != null) {
				return false;
			}
		} else if (!this.objectif.equals(other.objectif)) {
			return false;
		}
		if (this.populationCible == null) {
			if (other.populationCible != null) {
				return false;
			}
		} else if (!this.populationCible.equals(other.populationCible)) {
			return false;
		}
		if (this.thematique == null) {
			if (other.thematique != null) {
				return false;
			}
		} else if (!this.thematique.equals(other.thematique)) {
			return false;
		}
		if (this.typeAction == null) {
			if (other.typeAction != null) {
				return false;
			}
		} else if (!this.typeAction.equals(other.typeAction)) {
			return false;
		}
		if (this.typeSoutien == null) {
			if (other.typeSoutien != null) {
				return false;
			}
		} else if (!this.typeSoutien.equals(other.typeSoutien)) {
			return false;
		}
		if (this.zoneGeographiqe == null) {
			if (other.zoneGeographiqe != null) {
				return false;
			}
		} else if (!this.zoneGeographiqe.equals(other.zoneGeographiqe)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Proposition [idProposition=" + this.idProposition + ", thematique=" + this.thematique + ", objectif="
				+ this.objectif + ", typeAction=" + this.typeAction + ", datePrevision=" + this.datePrevision
				+ ", populationCible=" + this.populationCible + ", zoneGeographiqe=" + this.zoneGeographiqe
				+ ", dureeAction=" + this.dureeAction + ", budgetPrevisionnel=" + this.budgetPrevisionnel
				+ ", typeSoutien=" + this.typeSoutien + "]";
	}

}
