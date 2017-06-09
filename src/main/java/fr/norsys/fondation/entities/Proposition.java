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
	@ManyToOne
	@JoinColumn(name = "ID_THEMATIQUE")
	private Thematique thematique;
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
	private String annexe;
	@Column(name = "ETAT")
	private String etat;

	public Proposition() {
	}

	public int getIdProposition() {
		return this.idProposition;
	}

	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
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
		return this.annexe;
	}

	public void setAnnexe(String annexe) {
		this.annexe = annexe;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Thematique getThematique() {
		return this.thematique;
	}

	public void setThematique(Thematique thematique) {
		this.thematique = thematique;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annexe == null) ? 0 : annexe.hashCode());
		result = prime * result + ((budgetPrevisionnel == null) ? 0 : budgetPrevisionnel.hashCode());
		result = prime * result + ((datePrevision == null) ? 0 : datePrevision.hashCode());
		result = prime * result + ((dureeAction == null) ? 0 : dureeAction.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + idProposition;
		result = prime * result + ((objectif == null) ? 0 : objectif.hashCode());
		result = prime * result + ((populationCible == null) ? 0 : populationCible.hashCode());
		result = prime * result + ((porteurProjet == null) ? 0 : porteurProjet.hashCode());
		result = prime * result + ((thematique == null) ? 0 : thematique.hashCode());
		result = prime * result + ((typeAction == null) ? 0 : typeAction.hashCode());
		result = prime * result + ((typeSoutien == null) ? 0 : typeSoutien.hashCode());
		result = prime * result + ((zoneGeographiqe == null) ? 0 : zoneGeographiqe.hashCode());
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
		Proposition other = (Proposition) obj;
		if (annexe == null) {
			if (other.annexe != null)
				return false;
		} else if (!annexe.equals(other.annexe))
			return false;
		if (budgetPrevisionnel == null) {
			if (other.budgetPrevisionnel != null)
				return false;
		} else if (!budgetPrevisionnel.equals(other.budgetPrevisionnel))
			return false;
		if (datePrevision == null) {
			if (other.datePrevision != null)
				return false;
		} else if (!datePrevision.equals(other.datePrevision))
			return false;
		if (dureeAction == null) {
			if (other.dureeAction != null)
				return false;
		} else if (!dureeAction.equals(other.dureeAction))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (idProposition != other.idProposition)
			return false;
		if (objectif == null) {
			if (other.objectif != null)
				return false;
		} else if (!objectif.equals(other.objectif))
			return false;
		if (populationCible == null) {
			if (other.populationCible != null)
				return false;
		} else if (!populationCible.equals(other.populationCible))
			return false;
		if (porteurProjet == null) {
			if (other.porteurProjet != null)
				return false;
		} else if (!porteurProjet.equals(other.porteurProjet))
			return false;
		if (thematique == null) {
			if (other.thematique != null)
				return false;
		} else if (!thematique.equals(other.thematique))
			return false;
		if (typeAction == null) {
			if (other.typeAction != null)
				return false;
		} else if (!typeAction.equals(other.typeAction))
			return false;
		if (typeSoutien == null) {
			if (other.typeSoutien != null)
				return false;
		} else if (!typeSoutien.equals(other.typeSoutien))
			return false;
		if (zoneGeographiqe == null) {
			if (other.zoneGeographiqe != null)
				return false;
		} else if (!zoneGeographiqe.equals(other.zoneGeographiqe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proposition [idProposition=" + idProposition + ", thematique=" + thematique + ", objectif=" + objectif
				+ ", typeAction=" + typeAction + ", datePrevision=" + datePrevision + ", populationCible="
				+ populationCible + ", zoneGeographiqe=" + zoneGeographiqe + ", dureeAction=" + dureeAction
				+ ", budgetPrevisionnel=" + budgetPrevisionnel + ", typeSoutien=" + typeSoutien + ", porteurProjet="
				+ porteurProjet + ", annexe=" + annexe + ", etat=" + etat + "]";
	}

	

}
