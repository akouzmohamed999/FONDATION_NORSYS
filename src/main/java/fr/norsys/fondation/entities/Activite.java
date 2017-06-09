package fr.norsys.fondation.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "ACTIVITE")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idActivite")
public class Activite implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ACTIVITE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActivite;
	@Column(name = "INTITULE")
	private String intitule;
	@Column(name = "DATE_ACTIVITE")
	private Date dateActivite;
	@Column(name = "DATE_FIN")
	private Date dateFin;
	@Column(name = "ETAT")
	private String etat;
	@Column(name = "LIEU")
	private String lieu;
	@ManyToOne(targetEntity = Collaborateur.class)
	@JoinColumn(name = "ID_ANIMATEUR")
	private Collaborateur animateurTerrain;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Composante.class)
	@JoinColumn(name = "ID_COMPOSANTE")
	private Composante composante;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy="activites")
	private List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "activites")
	private List<Benificiaire> benificiaires = new ArrayList<Benificiaire>();

	public Activite() {
	}

	public Activite(int idActivite, String intitule, Date dateActivite, Date dateFin, String etat, String lieu,
			Collaborateur animateurTerrain, Composante composante) {
		super();
		this.idActivite = idActivite;
		this.intitule = intitule;
		this.dateActivite = dateActivite;
		this.dateFin = dateFin;
		this.etat = etat;
		this.lieu = lieu;
		this.animateurTerrain = animateurTerrain;
		this.composante = composante;
		composante.getActivites().add(this);
	}

	public Activite(int idActivite, String intitule, Date dateActivite, Date dateFin, String etat, String lieu,
			Collaborateur animateurTerrain, Composante composante, List<Benificiaire> benificiaire) {
		super();
		this.idActivite = idActivite;
		this.intitule = intitule;
		this.dateActivite = dateActivite;
		this.dateFin = dateFin;
		this.etat = etat;
		this.lieu = lieu;
		this.animateurTerrain = animateurTerrain;
		this.composante = composante;
		composante.getActivites().add(this);
		this.benificiaires = benificiaire;
	}

	public int getIdActivite() {
		return this.idActivite;
	}

	public void setIdActivite(int idActivite) {
		this.idActivite = idActivite;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDateActivite() {
		return this.dateActivite;
	}

	public void setDateActivite(Date dateActivite) {
		this.dateActivite = dateActivite;
	}


	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getLieu() {
		return this.lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Collaborateur getAnimateurTerrain() {
		return this.animateurTerrain;
	}

	public void setAnimateurTerrain(Collaborateur animateurTerrain) {
		this.animateurTerrain = animateurTerrain;
	}

	public Composante getComposante() {
		return this.composante;
	}

	public void setComposante(Composante composante) {
		this.composante = composante;
	}

	public List<Collaborateur> getCollaborateurs() {
		return this.collaborateurs;
	}

	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public List<Benificiaire> getBenificiaires() {
		return this.benificiaires;
	}

	public void setBenificiaires(List<Benificiaire> benificiaires) {
		this.benificiaires = benificiaires;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateActivite == null) ? 0 : dateActivite.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + idActivite;
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
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
		Activite other = (Activite) obj;
		if (dateActivite == null) {
			if (other.dateActivite != null)
				return false;
		} else if (!dateActivite.equals(other.dateActivite))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (idActivite != other.idActivite)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Activite [idActivite=" + idActivite + ", intitule=" + intitule + ", dateActivite=" + dateActivite
				+ ", dateFin=" + dateFin + ", etat=" + etat + ", lieu=" + lieu + ", animateurTerrain="
				+ animateurTerrain + ", composante=" + composante + "]";
	}

	

}
