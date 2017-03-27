package fr.norsys.fondation.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Table(name = "PROPOSITION")
public class Proposition {

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
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PorteurProjet.class)
	@JoinColumn(name = "ID_PORTEUR_PROJET")
	private PorteurProjet porteurProjet;
	@OneToOne(fetch = FetchType.LAZY, targetEntity = Projet.class)
	@JoinColumn(name = "ID_PROJET")
	@Null
	private Projet projet;

	public Proposition() {
	}

	public Proposition(String thematique, String objectif, String typeAction, Date datePrevision,
			String populationCible, String zoneGeographiqe, String dureeAction, String budgetPrevisionnel,
			String typeSoutien, PorteurProjet porteurProjet, Projet projet) {
		super();
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
		this.projet = projet;
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

	public Projet getProjets() {
		return this.projet;
	}

	public void setProjets(Projet projet) {
		this.projet = projet;
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
		if (this.porteurProjet == null) {
			if (other.porteurProjet != null) {
				return false;
			}
		} else if (!this.porteurProjet.equals(other.porteurProjet)) {
			return false;
		}
		if (this.projet == null) {
			if (other.projet != null) {
				return false;
			}
		} else if (!this.projet.equals(other.projet)) {
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
				+ ", typeSoutien=" + this.typeSoutien + ", porteurProjet=" + this.porteurProjet + ", projet="
				+ this.projet + "]";
	}

}
